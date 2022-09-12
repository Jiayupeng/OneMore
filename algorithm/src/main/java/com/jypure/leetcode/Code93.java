package com.jypure.leetcode;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 * @author : jiayupeng
 * @date : 2022/9/12/09:39
 */
public class Code93 {


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }

        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }


}
