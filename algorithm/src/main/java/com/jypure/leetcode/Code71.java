package com.jypure.leetcode;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 * @author : jiayupeng
 * @date : 2022/8/8/10:26
 */
public class Code71 {

    //贪心：局部最优推出全局最优

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            //如果count小于0了，那么重置为0，因为负数一定会拉低整个的和，等于是重置了计算和的起始点
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }


}
