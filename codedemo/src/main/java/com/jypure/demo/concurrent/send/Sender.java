package com.jypure.demo.concurrent.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : jiayupeng
 * @date : 2020/5/29/0:46
 */
public class Sender implements Runnable {

    private static final Logger Log = LoggerFactory.getLogger(Sender.class);


    private Data data;

    public Sender(Data data) {
        this.data = data;
    }


    @Override
    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
    }
}
