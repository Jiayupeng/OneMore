package com.jypure.leetcode;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * 爬楼梯改：一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶呢？
 * @author : jiayupeng
 * @date : 2022/9/9/10:40
 */
public class Code92 {

    public int climbStairs(int n){
        //定义dp数组
        int[] dp = new int[n + 1];
        int[] weight = {1,2};
        //确定递推公式
        //初始化dp数组
        dp[0] = 1;
        //确定遍历顺序
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i >= weight[j]) {
                    dp[i] += dp[i - weight[j]];
                }
            }
        }

        return dp[n];
    }



}
