package com.jypure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode.cn/problems/3sum/
 * @author : jiayupeng
 * @date : 2022/7/11/10:46
 */
public class Code11 {

    /**
     * 双指针法的应用。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //排序后，如果这个数大于0，不可能和后面其他的两个数组合使得相加结果为0
            if (nums[i] > 0) {
                return result;
            }

            //如果当前的数和前一个数相等，继续往后
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //双指针法
            int left = i + 1;
            int right = nums.length -1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //处理重复值
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    while (right > left && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;

    }



}
