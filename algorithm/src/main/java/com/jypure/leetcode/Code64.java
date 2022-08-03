package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 * @author : jiayupeng
 * @date : 2022/8/3/21:46
 */
public class Code64 {


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        //root 在[low,high]范围内
        //root->left接入符合条件的左孩子
        root.left = trimBST(root.left, low, high);
        //root->right接入符合条件的右孩子
        root.right = trimBST(root.right, low, high);
        return root;
    }


}
