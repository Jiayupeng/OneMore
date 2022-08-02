package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * @author : jiayupeng
 * @date : 2022/8/2/16:22
 */
public class Code57 {

    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        //中序遍历

        //左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        //中
        if (max != null && root.val <= max.val) {
            return false;
        }

        max = root;

        boolean right = isValidBST(root.right);
        return right;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                stack.pop();
                if (pre != null && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }



}
