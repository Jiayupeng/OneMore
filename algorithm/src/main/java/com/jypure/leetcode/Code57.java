package com.jypure.leetcode;

import com.jypure.TreeNode;

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



}
