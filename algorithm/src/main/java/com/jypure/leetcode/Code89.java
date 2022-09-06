package com.jypure.leetcode;

/**https://programmercarl.com/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * @author : jiayupeng
 * @date : 2022/9/6/09:38
 */
public class Code89 {

    public static void main(String[] args) {
        testCompletePack();
    }

    //先遍历物品，再遍历背包
    public static void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15,20,30};
        int bagWeight = 4;
        //j是背包容量
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {//遍历物品
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int i : dp) {
            System.out.println(i + "  ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15,20,30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++) {//遍历背包容量
            for (int j = 0; j < weight.length; j++) {//遍历物品
                if (i - weight[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }

        for (int i : dp) {
            System.out.println(i + "  ");
        }
    }

}
