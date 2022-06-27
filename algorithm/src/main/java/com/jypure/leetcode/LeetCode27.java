package com.jypure.leetcode;

/**
 * @author : jiayupeng
 * @date : 2022/6/25/14:18
 */
public class LeetCode27 {

    public static void main(String[] args){
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = removeElement1(nums, val);
        System.out.println(i);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(",");
        }
    }

    public static int removeElement(int[] nums, int val) {

        int lastIndex = nums.length - 1;
        for(int i = 0; i <= lastIndex; i++) {
            if (nums[i] == val) {
                while (lastIndex >= 0 && nums[lastIndex] == val) {
                    lastIndex -= 1;
                }
                if (lastIndex > i) {
                    nums[i] = nums[lastIndex];
                    lastIndex-=1;
                } else {
                    return lastIndex + 1;
                }
            }
        }
        return lastIndex + 1;

    }

    /**
     * 快慢指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {

        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        return slowIndex;
    }

}
