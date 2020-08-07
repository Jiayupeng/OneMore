package com.jypure.demo.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : jiayupeng
 * @date : 2020/5/28/11:59
 */
public class ThreadPoolService {

    public static void main(String[] args) {
        ThreadPoolService ts = new ThreadPoolService();
        ts.execExecutor();
        ts.execExecutorService();
    }

    public void execExecutor(){
        Executor executorService = Executors.newSingleThreadExecutor();

        executorService.execute(()-> System.out.println("hello world"));

    }

    public void execExecutorService(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "hello World");

        try {
            String s = future.get();

            System.out.println("s:" + s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
