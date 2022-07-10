package com.jypure.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum/
 * @author : jiayupeng
 * @date : 2022/7/10/11:14
 */
public class Code8 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[1] = i;
                res[0] = map.get(tmp);
            }
            map.put(nums[i], i);
        }

        return res;
    }

}
