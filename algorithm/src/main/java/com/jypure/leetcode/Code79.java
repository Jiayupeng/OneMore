package com.jypure.leetcode;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/
 * @author : jiayupeng
 * @date : 2022/8/16/09:33
 */
public class Code79 {

    public int uniquePaths(int m, int n) {
        //确定dp数组以及下标的含义， dp[i][j]到每一个坐标可能的路径种类
        int[][] dp = new int[m][n];
        //dp数组初始化 dp[i][0] = 1 dp[0][i] = 1 初始化横竖即可
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //确定递推公式， dp[i][j] = dp[i-1][j] dp[i][j-1]
        //确定遍历顺序 一行一行遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        //举例推导dp数组
        return dp[m-1][n-1];
    }

}
