package com.jypure.leetcode;

/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 * @author : jiayupeng
 * @date : 2022/8/8/14:56
 */
public class Code74 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        //记录跳跃的次数
        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖的区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);

            //说明当前一步，再跳一步就达到了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }

            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }

        return count;

    }

    public int jump1(int[] nums) {
        int result = 0;
        //当前覆盖的最远距离下标
        int end = 0;
        //下一步覆盖的最远距离下标
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; i++) {
            temp = Math.max(temp, i + nums[i]);
            //可达位置的改变次数就是跳跃次数
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }

}
