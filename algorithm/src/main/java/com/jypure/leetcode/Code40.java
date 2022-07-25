package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @author : jiayupeng
 * @date : 2022/7/21/16:27
 */
public class Code40 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        int deep = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len > 0) {
                TreeNode poll = que.poll();
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
                len--;
            }
            deep++;
        }


        return deep;

    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


}
