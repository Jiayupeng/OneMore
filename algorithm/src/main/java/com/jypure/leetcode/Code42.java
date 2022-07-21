package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 * @author : jiayupeng
 * @date : 2022/7/21/19:21
 */
public class Code42 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);

        return root;
    }

    public void swapChildren(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

}
