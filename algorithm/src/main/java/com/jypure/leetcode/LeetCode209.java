package com.jypure.leetcode;

import java.util.HashMap;

/**
 * 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/submissions/
 * @author : jiayupeng
 * @date : 2022/6/25/20:45
 */
public class LeetCode209 {

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 2, 2};


    }


    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = minLength < (i - start + 1) ? minLength : (i - start + 1);
                sum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;


    }


    /**
     * 水果成篮
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int left = 0;
        int max = -1;

        Counter count = new Counter();

        for (int i = 0; i < fruits.length; i++) {
            count.add(fruits[i], 1);
            while (count.size() > 2) {
                count.add(fruits[left], -1);
                if (count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        return max;

    }

    class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }



}
