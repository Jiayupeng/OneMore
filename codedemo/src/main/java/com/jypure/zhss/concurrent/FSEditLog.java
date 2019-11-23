package com.jypure.zhss.concurrent;

import java.util.LinkedList;

/**
 * 一个日志写入的类，使用txid全局id，双缓冲机制实现
 * @author : jiayupeng
 * @date : 2019/11/23/21:41
 */
public class FSEditLog {
    /**
     * 当前递增到的txid序号
     */
    private long txidSeq = 0L;
    /**
     * 内存双缓冲区
     */
    private DoubleBuffer editLogBuffer = new DoubleBuffer();

    /**
     * 当前是否在将内存缓冲刷写到磁盘中去
     */
    private volatile Boolean isSyncRunning = false;

    /**
     * 是否有线程在等待刷新下一批的editlog到磁盘中去
     */
    private volatile Boolean isWaitSync = false;

    /**
     * 在同步到磁盘的最大的txid
     */
    private volatile Long syncMaxTxid = 0L;

    /**
     * 每个线程保存的自己本地的txid副本
     */
    private ThreadLocal<Long> localTxid = new ThreadLocal<>();

    /**
     * 写入log
     * @param content
     */
    public void logEdit(String content) {
        synchronized (this) {
            txidSeq ++;
            long txid = txidSeq;
            localTxid.set(txid);
            //构造一个editLog对象，写入内存
            EditLog log = new EditLog(txid, content);
            editLogBuffer.write(log);
        }
        logSync();
    }

    /**
     * 将内存缓冲中的数据刷写到磁盘中去
     * 相当于是批量将内存中的数据刷到磁盘中
     */
    private void logSync() {
        //这里加锁后，因为都是用的this锁，上面写入log的同步代码块也进不去了，因此这里要尽快释放锁
        synchronized (this) {
            //是否已经在执行刷写磁盘了
            if (isSyncRunning) {
                Long txid = localTxid.get();
                //如果txid小于正在往磁盘中刷的editlog的最大txid，那这个线程就不需要等待了，直接返回
                //因为此时这个txid的editlog一定会被刷到磁盘中去的
                if (txid <= syncMaxTxid) {
                    return;
                }

                //如果线程本地的txid是大于正在刷磁盘的最大txid的，那这里就需要做些处理
                //判断一下当前是否有线程在等待将下一批editlog刷写到磁盘中去
                if (isWaitSync) {
                    //如果已经有线程在等待将下一批editlog刷到磁盘中去，那么当前进来的这个线程就不用做什么了，直接返回
                    //因为会有别的线程将它的editlog刷到磁盘中去的
                    return;
                }

                //到这里，说明没有一个线程在等待执行将下一批editlog刷到磁盘中去，那么这个线程就需要做这件事了
                //首先，将是否有线程在等待刷新下一批editlog的标志位设置为true
                isWaitSync = true;
                //然后，循环等待，直到上一批editlog已经刷新完毕了
                //等待，要使用wait机制，因为，wait可以释放当前持有的锁，就不会影响别的线程继续往内存中写入editlog了！
                while (isSyncRunning) {
                    try {
                        wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //到这里，说明上一批的刷磁盘操作已经结束了，可以将等待标志位恢复成false，执行这一批的刷磁盘操作了！
                isWaitSync = false;
            }

            //进行刷写磁盘的准备工作，也就是将current缓冲和sync缓冲进行交换
            editLogBuffer.setReadyToSync();

            //获取到当前正在进行刷到磁盘的editlog的最大txid
            syncMaxTxid = editLogBuffer.getSyncMaxTxid();

            //将是否在进行刷到磁盘的标志位设置为true
            isSyncRunning = true;
        }
        //进行刷写磁盘的工作,因为这是一个很耗时间的操作，因此要放到同步代码块的外面
        editLogBuffer.flush();
        synchronized (this) {
            //同步完磁盘之后，要将标志位恢复到false，再释放锁
            isSyncRunning = false;
            //唤醒可能正在等待它同步到磁盘的标志位
            notifyAll();
        }
    }

    class EditLog{
        long txid;
        String content;

        public EditLog(long txid, String content) {
            this.txid = txid;
            this.content = content;
        }

    }

    /**
     * 双缓冲机制
     */
    class DoubleBuffer{
        /**
         * 承载线程写入edits log的缓冲
         */
        LinkedList<EditLog> currentBuffer = new LinkedList<>();
        /**
         * 将数据同步到磁盘中的缓冲
         */
        LinkedList<EditLog> syncBuffer = new LinkedList<>();

        /**
         * 将editlog写入到内存缓冲中
         * @param log
         */
        public void write(EditLog log){
            currentBuffer.add(log);
        }

        /**
         * 获取当前正在刷往磁盘的缓冲区中最大的txid序号
         * @return
         */
        public long getSyncMaxTxid(){
            return syncBuffer.getLast().txid;
        }

        /**
         * 交换两块缓冲区，为了同步内存数据到磁盘做准备
         */
        public void setReadyToSync(){
            LinkedList<EditLog> tmp = currentBuffer;
            currentBuffer = syncBuffer;
            syncBuffer = tmp;
        }

        /**
         * 将syncBuffer中的数据同步到磁盘
         */
        public void flush(){
            for (EditLog editLog : syncBuffer) {
                //模拟写入磁盘
                System.out.println("将edit log写入到磁盘中" + editLog);
            }
            syncBuffer.clear();
        }
    }
}
