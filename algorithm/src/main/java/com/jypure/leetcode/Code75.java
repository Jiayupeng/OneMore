package com.jypure.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1005. K 次取反后最大化的数组和
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 * @author : jiayupeng
 * @date : 2022/8/9/11:03
 */
public class Code75 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        //按照绝对值大小从大到小排序
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        //如果k还大于0，就反复转变数值最小的元素，将k用完
        if (k % 2 == 1){//k是单数，最后转换的结果，数值最小的值最后的值应该是当前值的反转值
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();

    }

}
