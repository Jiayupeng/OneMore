package com.jypure.leetcode;

/**
 * @author : jiayupeng
 * @date : 2022/6/20/22:38
 */
public class LeetCode704 {

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */

    static class Solution{

        public static void main(String[] args){

            int[] nums = {1,3,6,7,10,13,20,34,54,67,68,90,120,234,1234,2345};

            int search = search2(nums, 2345);

            System.out.println(search);

        }


        /**
         * 定义target在左闭右闭的空间里
         * @param nums
         * @param target
         * @return
         */
        public static int search1(int[] nums, int target) {
            //首先进行区间的定义
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int middle = left + ((right - left) / 2);
                if (nums[middle] > target) {
                    right = middle - 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            }

            return -1;
        }


        /**
         * 定义target在左闭右开区间
         * @param nums
         * @param target
         * @return
         */
        public static int search2(int[] nums, int target) {
            int left = 0;
            int right = nums.length;


            while (left < right) {
                int middle = left + ((right - left) / 2);
                if (nums[middle] > target) {
                    right = middle;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            }
            return -1;


        }

    }




}
