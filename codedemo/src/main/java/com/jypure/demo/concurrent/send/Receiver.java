package com.jypure.demo.concurrent.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : jiayupeng
 * @date : 2020/5/29/0:49
 */
public class Receiver implements Runnable {
    private static final Logger Log = LoggerFactory.getLogger(Receiver.class);


    private Data load;

    // standard constructors

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for(String receivedMessage = load.receive();
            !"End".equals(receivedMessage);
            receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
    }
}
