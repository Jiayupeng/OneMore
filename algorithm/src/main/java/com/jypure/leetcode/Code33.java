package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/submissions/
 * 二叉树的层序遍历 II
 * @author : jiayupeng
 * @date : 2022/7/21/15:25
 */
public class Code33 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        fun1(resList, root, 0);
        Collections.reverse(resList);

        return resList;
    }

    public void fun1(List<List<Integer>> resList, TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            List<Integer> item = new LinkedList<>();
            resList.add(item);
        }

        if (node.right != null) {
            fun1(resList, node.right, deep);
        }

        resList.get(deep - 1).add(node.val);

    }

}
