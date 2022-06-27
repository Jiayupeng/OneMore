package com.jypure.leetcode;

/**
 * @author : jiayupeng
 * @date : 2022/6/25/22:26
 */
public class LeetCode59 {

    public static void main(String[] args){

    }


    public int[][] generateMatrix(int n) {

        int l = 0, r = n -1, t = 0, b = n - 1;
        int[][] res = new int[n][n];
        int num = 1, tar = n * n;

        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;

            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;

            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }

        return res;






    }

}
