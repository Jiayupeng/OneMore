package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/
 * @author : jiayupeng
 * @date : 2022/8/1/22:07
 */
public class Code56 {


    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return null;
    }

    public TreeNode searchBST1(TreeNode root, int val){
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        return null;
    }

}
