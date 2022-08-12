package com.jypure.leetcode;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 * @author : jiayupeng
 * @date : 2022/8/12/10:10
 */
public class Code78 {


    public int climbStairs(int n) {

        if (n <= 1) {
            return n;
        }

        //dp数组，下标i和值的含义是，第i级台阶，有多少种方式上来
        int[] dp = new int[n + 1];
        //初始化dp数组
        dp[1] = 1;
        dp[2] = 2;
        //递推公式
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
