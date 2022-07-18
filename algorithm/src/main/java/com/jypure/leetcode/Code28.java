package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @author : jiayupeng
 * @date : 2022/7/18/17:31
 */
public class Code28 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @param result
     */
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

}
