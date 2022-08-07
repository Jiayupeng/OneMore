package com.jypure.leetcode;

/**
 * 376. 摆动序列
 * https://leetcode.cn/problems/wiggle-subsequence/
 * @author : jiayupeng
 * @date : 2022/8/7/13:04
 */
public class Code70 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            //当前差值
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }



}
