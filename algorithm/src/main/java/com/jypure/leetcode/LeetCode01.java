package com.jypure.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author : jiayupeng
 * @date : 2019/11/20/15:34
 */
public class LeetCode01 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == tmp){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 用hash表完成, leetcode 官方题解
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] ints = twoSumByHash(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
