package com.jypure.demo.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : jiayupeng
 * @date : 2021/3/17/23:19
 */
@SuppressWarnings("all")
public class StreamTest {

    public static void main(String[] args){

        List<String> strings = Arrays.asList("Apple", "dog", "Ahhhhh", "hello", "Abc");

        OptionalInt a = strings.stream()
                .filter(s -> s.startsWith("A"))
                .mapToInt(String::length)
                .distinct()
                .max();

        int longestLength = a.isPresent() ? a.getAsInt() : 0;

//        System.out.println(longestLength);



//        list.distinct().collect()


        List<Integer> collect = Lists.newArrayList(1, 2, 3, 4, 5)
                .stream()
                .parallel()
                .map(i -> i + 1)
                .collect(Collectors.toList());//[2,3,4,5,6]

        System.out.println(collect);

        boolean b = collect.removeIf(i -> i > 2);
        System.out.println("111==" + collect);


        IntStream list = IntStream.range(0, 5);
        Set<Thread> threadSet = new HashSet<>();
        //开始并行执行
        list.parallel().forEach(i -> {
            Thread thread = Thread.currentThread();
            System.err.println("integer：" + i + "，" + "currentThread:" + thread.getName());
            threadSet.add(thread);
        });

        Optional<Object> absent = Optional.absent();

        System.out.println(absent.isPresent());

        Object or = absent.or(1);

        System.out.println(or);

        Integer tmp = null;

        Integer or1 = Optional.of(tmp).or(2);

        System.out.println(or1);
    }

}
