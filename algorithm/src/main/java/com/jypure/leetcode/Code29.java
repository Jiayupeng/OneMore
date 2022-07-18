package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @author : jiayupeng
 * @date : 2022/7/18/17:36
 */
public class Code29 {


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;

    }

    /**
     * 后序遍历
     * @param root
     * @param result
     */
    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

}
