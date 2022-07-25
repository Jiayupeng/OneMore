package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 * 对称二叉树
 *
 * @author : jiayupeng
 * @date : 2022/7/25/11:03
 */
public class Code43 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);

    }

    /**
     * 递归
     * @param left
     * @param right
     * @return
     */
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);

        return outside && inside;
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);

        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }



}
