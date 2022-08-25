package com.jypure.leetcode;

/**
 * 背包问题1
 * @author : jiayupeng
 * @date : 2022/8/25/09:55
 */
public class Code83 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
    }

    //两者比较：
    //1、如果不放第i个物品，那么i-1个物品的最大值是多少
    //2、如果放第i个物品，那么i-1个物品，空出第i个物品所需要占用的空间(剩余j-weight[i]空间)，所具有的最大价值，加上第i个物品的价值
    //dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
    public static void testweightbagproblem(int[] weight, int[] value, int bagsize){
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        //初始化，背包容量为0时，价值都是0
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        //先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen ; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i <= wlen; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

    }


}
