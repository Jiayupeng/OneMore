package com.jypure.zhss.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 一个心跳计数器，使用原子类，进行心跳统计
 * @author : jiayupeng
 * @date : 2019/11/24/12:32
 */
public class HeartBeatCounter {

    private static final Logger logger = LoggerFactory.getLogger(HeartBeatCounter.class);

    /**
     * 单例
     */
    private static HeartBeatCounter instance = new HeartBeatCounter();

    /**
     * 最近一分钟的心跳次数
     */
    private AtomicLong latestMinuteHeartBeatRate = new AtomicLong(0L);

    /**
     * 最近一分钟的时间戳
     */
    private long latestMinuteTimestamp = System.currentTimeMillis();

    /**
     * 私有化构造器
     */
    private HeartBeatCounter() {
        Daemon daemon = new Daemon();
        daemon.setDaemon(true);
        daemon.start();
    }

    /**
     * 获取单例实例
     * @return
     */
    public static HeartBeatCounter getInstance() {
        return instance;
    }

    public void increment(){
        latestMinuteHeartBeatRate.incrementAndGet();
    }

    /**
     * 获取最近一分钟的心跳次数
     * @return
     */
    public long get(){
        return latestMinuteHeartBeatRate.get();
    }

    private class Daemon extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    long currentTime = System.currentTimeMillis();
                    if(currentTime - latestMinuteTimestamp > 60 * 1000) {
                        latestMinuteHeartBeatRate = new AtomicLong(0L);
                        latestMinuteTimestamp = System.currentTimeMillis();
                    }
                    Thread.sleep(1000);
                } catch(Exception e){
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
