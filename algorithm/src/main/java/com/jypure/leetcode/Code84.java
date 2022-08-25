package com.jypure.leetcode;

/**
 * 背包问题一维数组
 * @author : jiayupeng
 * @date : 2022/8/25/15:58
 */
public class Code84 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    //在一维dp数组中，dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wlen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        //数组默认值是0
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wlen; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                //在原来的二维数组，这一层的值，取决于上一层的值，比较的是上一层i-1个物品，j个容量的最大值
                // 和上一层i-1个物品，j-weight[i]的容量，再加上value[i]的值
                //如果把上一层的值复制到下一层，重叠之后,就是下面这个递推公式
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }

    }

}
