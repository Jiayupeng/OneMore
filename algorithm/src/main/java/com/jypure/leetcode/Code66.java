package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @author : jiayupeng
 * @date : 2022/8/4/11:01
 */
public class Code66 {

    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    /**
     * 按右中左的顺序遍历和累加
     * @param root
     */
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }

        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);

    }


}
