package com.jypure.demo.concurrent.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : jiayupeng
 * @date : 2020/5/29/0:47
 */
public class Data {
    private static final Logger Log = LoggerFactory.getLogger(Data.class);


    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }

}
