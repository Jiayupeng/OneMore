package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author : jiayupeng
 * @date : 2022/8/2/19:38
 */
public class Code60 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) { // 若未找到节点p或q
            return null;
        } else if (left == null && right != null) {// 若找到一个节点
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return root;
        }

    }

}
