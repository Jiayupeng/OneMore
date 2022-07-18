package com.jypure.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/submissions/
 * 二叉树的前序遍历
 * @author : jiayupeng
 * @date : 2022/7/18/16:55
 */
public class Code27 {


    /*
    递归的三要素：
    1、递归函数的参数和返回值
    2、确定终止条件
    3、确定单层递归的逻辑
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<Integer> preorderTravelsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    /**
     * 前序遍历
     * @param root
     * @param result
     */
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }


}
