package com.jypure.leetcode;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode.cn/problems/last-stone-weight-ii/
 * @author : jiayupeng
 * @date : 2022/9/1/11:22
 */
public class Code86 {


    public int lastStoneWeightII(int[] stones){
        int sum = 0;
        for (int i : stones) {
            sum+=i;
        }

        int target = sum >> 1;
        //初始化dp数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }


}
