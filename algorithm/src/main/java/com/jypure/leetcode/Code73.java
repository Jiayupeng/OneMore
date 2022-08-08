package com.jypure.leetcode;

/**
 * 55. 跳跃游戏
 * 每一步更新的最大覆盖范围，看是否能覆盖到最后一个位置
 * https://leetcode.cn/problems/jump-game/
 * @author : jiayupeng
 * @date : 2022/8/8/11:12
 */
public class Code73 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        Code73 code73 = new Code73();
        boolean b = code73.canJump(nums);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        //覆盖范围，初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
