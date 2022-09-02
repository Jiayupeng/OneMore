package com.jypure.leetcode;

/**
 * 494. 目标和
 * https://leetcode.cn/problems/target-sum/
 * @author : jiayupeng
 * @date : 2022/9/2/15:03
 */
public class Code87 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((target + sum) % 2 != 0) {
            return 0;
        }

        //加法的值是size
        //加法的总和为x，那么减法对应的总和就是sum-x
        //所以 x - (sum - x) = target
        //所以 x = (sum + target) / 2
        int size = (target + sum) / 2;
        if (size < 0) {
            size = -size;
        }

        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[size];
    }


}
