package com.jypure.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * @author : jiayupeng
 * @date : 2022/7/8/23:50
 */
public class Code6 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }


        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ret[i ++] =integer;
        }

        return ret;
    }


}
