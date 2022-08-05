package com.jypure.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode.cn/problems/combinations/
 * @author : jiayupeng
 * @date : 2022/8/4/16:33
 */
public class Code67 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param n
     * @param k
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        //剪枝
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combineHelper(n, k, i + 1);
            //回溯
            path.removeLast();
        }
    }


}
