package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/submissions/
 * 二叉树的层序遍历
 * @author : jiayupeng
 * @date : 2022/7/20/14:33
 */
public class Code32 {

    public List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
//        checkFun01(root, 0);

        checkFun02(root);
        return resList;
    }

    /**
     * DFS--递归方式
     * @param node
     * @param deep
     */
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }

        deep++;

        if (resList.size() < deep) {
            //当层级增加时， list的item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);

    }

    /**
     * DFS--迭代方式--借助队列
     * @param node
     */
    public void checkFun02(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);
        while (!que.isEmpty()) {
            List<Integer> itemList = new LinkedList<>();
            int len = que.size();
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
    }

}
