package com.jypure.leetcode;

/**
 * 63. 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/
 * @author : jiayupeng
 * @date : 2022/8/17/11:36
 */
public class Code80 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        //dp数组，下标和含义
        int[][] dp = new int[n][m];
        //初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        //递推公式
        //遍历顺序
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }







}
