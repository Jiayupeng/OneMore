package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.Stack;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * @author : jiayupeng
 * @date : 2022/8/2/17:29
 */
public class Code58 {

    int min = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        if (root.left != null) {
            traversal(root.left);
        }

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;

        if (root.right != null) {
            traversal(root.right);
        }
    }


    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null) {
                    min = Math.min(min, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return min;
    }





}
