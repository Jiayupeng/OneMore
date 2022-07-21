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

}
