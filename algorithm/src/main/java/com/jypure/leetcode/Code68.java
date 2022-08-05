package com.jypure.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/
 * @author : jiayupeng
 * @date : 2022/8/5/14:57
 */
public class Code68 {

    public static void main(String[] args) {
        Code68 code68 = new Code68();
        code68.combinationSum3(3, 9);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
                return;
            }
        }
        //剪枝
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }


    }


}
