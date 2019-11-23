package com.jypure.zhss;

import java.util.LinkedList;
import java.util.List;

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
    private DoubleBuffer editLogBuffer;

    /**
     * 写入log
     * @param content
     */
    public void logEdit(String content) {
        synchronized (this) {
            txidSeq ++;
            long txid = txidSeq;
            EditLog log = new EditLog(txid, content);
            editLogBuffer.write(log);
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
        List<EditLog> currentBuffer = new LinkedList<>();
        /**
         * 将数据同步到磁盘中的缓冲
         */
        List<EditLog> syncBuffer = new LinkedList<>();

        /**
         * 将editlog写入到内存缓冲中
         * @param log
         */
        public void write(EditLog log){
            currentBuffer.add(log);
        }

        /**
         * 交换两块缓冲区，为了同步内存数据到磁盘做准备
         */
        public void setReadyToSync(){
            List<EditLog> tmp = currentBuffer;
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
