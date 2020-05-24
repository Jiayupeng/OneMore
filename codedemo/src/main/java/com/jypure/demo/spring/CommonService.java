package com.jypure.demo.spring;

import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : jiayupeng
 * @date : 2020/5/24/11:47
 */
@Service
public class CommonService {

    InnerClass inner;

    ExecutorService executorService ;

    public CommonService(){
        this.inner = new InnerClass("spring service inner class");
        executorService = Executors.newFixedThreadPool(5);
    }

    public String saySth(){
        return inner.getName();
    }

    public InnerClass getInner(){
        return inner;
    }


    public void fillInfo(){
        long startTime = System.currentTimeMillis() / 1000;
        System.out.println("begin time:" + startTime);

        CountDownLatch latch = new CountDownLatch(5);
        executorService.submit(()-> {
            try {
                System.out.println("task1 execute 1000");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        executorService.submit(()-> {
            try {
                System.out.println("task2 execute 2000");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        executorService.submit(()-> {
            try {
                System.out.println("task3 execute 1500");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        executorService.submit(()-> {
            try {
                System.out.println("task4 execute 2500");
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        executorService.submit(()-> {
            try {
                System.out.println("task5 execute 3000");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("task execute complete!");

        long endTime = System.currentTimeMillis() / 1000;
        System.out.println("endTime:" + endTime);
        System.out.println("cost:" + (endTime - startTime) + "second");


    }


    public class InnerClass{

        private String name;

        public InnerClass(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
