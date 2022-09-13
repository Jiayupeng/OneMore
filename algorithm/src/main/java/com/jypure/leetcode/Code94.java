package com.jypure.leetcode;

/**
 * 279. 完全平方数
 * https://leetcode.cn/problems/perfect-squares/
 * @author : jiayupeng
 * @date : 2022/9/13/10:07
 */
public class Code94 {


    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        for (int i = 1; i*i <= n ; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];


    }



}
