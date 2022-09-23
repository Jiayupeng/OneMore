package com.jypure.leetcode;

/**
 * 213. 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/
 * @author : jiayupeng
 * @date : 2022/9/23/10:52
 */
public class Code98 {


    public int rob(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        //分成两部分，从0到len-1, 从1到len，避免第一个和最后一个放到一起
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z= 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }


}
