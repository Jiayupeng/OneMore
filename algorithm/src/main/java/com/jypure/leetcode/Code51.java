package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii/
 * @author : jiayupeng
 * @date : 2022/8/1/16:09
 */
public class Code51 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    }

    public void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            preorderdfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);//回溯
        }
        if (root.right != null) {
            preorderdfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);//回溯
        }
    }

}
