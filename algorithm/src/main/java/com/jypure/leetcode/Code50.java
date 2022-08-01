package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 路径总和
 * https://leetcode.cn/problems/path-sum/
 * @author : jiayupeng
 * @date : 2022/8/1/15:39
 */
public class Code50 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {
                return true;
            }
        }

        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {
                return false;
            }
        }

        return false;
    }


    /**
     * 简洁
     * @param root
     * @param targetSum
     * @return
     */
    public boolean haspathsum1(TreeNode root, int targetSum) {
        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;

        // 求两侧分支的路径和
        return haspathsum1(root.left, targetSum - root.val) || haspathsum1(root.right, targetSum - root.val);
    }





}
