package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/
 * @author : jiayupeng
 * @date : 2022/7/25/17:03
 */
public class Code46 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * @param root
     * @return -1 表示已经不是平衡二叉树了，否则返回值是以该节点为根节点树的高度
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        //比较左子树和右子树的高度差，大于1就不是平衡二叉树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
