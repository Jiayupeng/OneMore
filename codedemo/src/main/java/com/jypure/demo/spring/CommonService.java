package com.jypure.demo.spring;

import com.jypure.demo.model.Person;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : jiayupeng
 * @date : 2020/5/24/11:47
 */
@Service
public class CommonService {

    InnerClass inner;

    List<Person> collect;
    ExecutorService executorService;

    public CommonService() {
        this.inner = new InnerClass("spring service inner class");
        executorService = Executors.newFixedThreadPool(6);
        collect = Stream.generate(Person::new).limit(10).collect(Collectors.toList());
    }

    public String saySth() {
        return inner.getName();
    }

    public InnerClass getInner() {
        return inner;
    }


    public List<Person> fillInfo() {
        long startTime = System.currentTimeMillis();
        System.out.println(executorService.toString());
        System.out.println("begin time:" + startTime);

        CountDownLatch latch = new CountDownLatch(6);


        System.out.println("collect size:" + collect.size());

        executorService.submit(() -> {
            try {
                System.out.println("task1 execute 1000");
                Thread.sleep(1000);
                collect.stream().forEach((n) -> n.setAddress("address "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("1count:" + latch.getCount());
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("task2 execute 2000");
                Thread.sleep(2000);
                collect.stream().forEach((n) -> n.setAge(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("2count:" + latch.getCount());
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("task3 execute 1500");
                Thread.sleep(1500);
                collect.stream().forEach((n) -> n.setScore(100D));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("3count:" + latch.getCount());
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("task4 execute 1000");
                Thread.sleep(1000);
                collect.stream().forEach((n) -> n.setUid(141002199900000032L));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("4count:" + latch.getCount());
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("task5 execute 1500");
                Thread.sleep(1500);
                collect.stream().forEach((n) -> n.setName("张三"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("5count:" + latch.getCount());
            }
        });

        executorService.submit(new FillInfoWorker(latch));

        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("interrupt");
            e.printStackTrace();
        }

        System.out.println("task execute complete!");

        long endTime = System.currentTimeMillis();
        System.out.println("endTime:" + endTime);
        System.out.println("cost:" + (endTime - startTime) + "millSecond");

        return collect;

    }


    public class InnerClass {

        private String name;

        public InnerClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class FillInfoWorker implements Runnable {

        CountDownLatch latch;

        FillInfoWorker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                System.out.println("task6 execute 1500");
                Thread.sleep(1500);
                collect.stream().forEach(n -> n.setInteresting("learn"));
                System.out.println("task6 complete");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }


}
