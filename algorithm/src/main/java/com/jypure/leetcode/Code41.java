package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * @author : jiayupeng
 * @date : 2022/7/21/16:39
 */
public class Code41 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        int deep = 0;
        while (!que.isEmpty()) {
            deep++;
            int len = que.size();
            while (len > 0) {
                TreeNode poll = que.poll();
                if (poll.left == null && poll.right == null) {
                    return deep;
                }
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
                len--;
            }
        }

        return deep;


    }

    /**
     * 递归，后序遍历，先处理左右孩子，再处理中节点
     *
     * 最小深度，是指从根节点，到最近的叶子节点的最短路径上的节点数量。
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //左孩子
        int leftDepth = minDepth1(root.left);
        //右孩子
        int rightDepth = minDepth1(root.right);

        //中间节点
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;


    }

}
