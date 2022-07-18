package com.jypure.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author : jiayupeng
 * @date : 2022/7/18/11:13
 */
public class Code26 {

    /*
    堆是一棵完全二叉树，树中每个结点的值都不小于（或不大于）其左右孩子的值。
    如果父亲结点是大于等于左右孩子就是大顶堆，小于等于左右孩子就是小顶堆。
     */




    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }

        return result;

    }
}
