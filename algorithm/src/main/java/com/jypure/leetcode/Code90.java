package com.jypure.leetcode;

/**
 * 518. 零钱兑换 II
 * https://leetcode.cn/problems/coin-change-2/
 * @author : jiayupeng
 * @date : 2022/9/7/09:43
 */
public class Code90 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1,2,5};
        change(amount, coins);
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么也不装
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        for (int i : dp) {
            System.out.print(i);
            System.out.print(",");
        }

        return dp[amount];
    }

}
