package com.jypure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多重背包
 * 转变为01背包
 * @author : jiayupeng
 * @date : 2022/9/20/09:29
 */
public class Code96 {

    public void testMultiPack1(){
        //版本1：改变物品数量为01背包格式
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;


        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) {
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.size(); i++) {//遍历物品
            for (int j = bagWeight; j >= weight.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }

    }

}
