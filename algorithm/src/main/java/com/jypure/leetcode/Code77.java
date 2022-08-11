package com.jypure.leetcode;

/**
 * 509. 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/
 * @author : jiayupeng
 * @date : 2022/8/11/15:26
 */
public class Code77 {


    /*
    5步曲：
    1、确定dp数组以及下标的含义
    2、确定递推公式
    3、dp数组如何初始化
    4、确定遍历顺序
    5、举例推导dp数组
     */

    public int fib(int n) {

        if (n < 2) {
            return n;
        }

        //dp数组，dp[i]表示第i个数的斐波那契数值
        int[] dp = new int[n + 1];

        //初始化dp数组，dp[0]是0，dp[1]是1
        dp[0] = 0;
        dp[1] = 1;

        //递推共识，题目里直接给出了
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //返回dp[n];
        return dp[n];
    }



}
