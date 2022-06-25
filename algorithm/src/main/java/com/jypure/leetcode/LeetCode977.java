package com.jypure.leetcode;

/**
 * 有序数组的平方
 * @author : jiayupeng
 * @date : 2022/6/25/15:01
 */
public class LeetCode977 {

    public static void main(String[] args){

        int[] nums = {-4, -1, 0, 3, 10};
        int[] ints = sortedSquares(nums);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];

            if (startSquare >= endSquare) {
                start ++;
                result[i] = startSquare;
            } else {
                end --;
                result[i] = endSquare;
            }

        }

        return result;
    }

}
