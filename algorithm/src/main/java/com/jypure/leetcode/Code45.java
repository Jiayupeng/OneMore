package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的节点个数
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 * @author : jiayupeng
 * @date : 2022/7/25/16:15
 */
public class Code45 {

    //完全二叉树：只有最下面一层右节点可能没有填满，其余层的节点数都达到最大值。
    //最下面一层的节点都集中在该层最左边的若干位置。

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        int count = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len-- > 0) {
                count++;
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return count;

    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        return getNodesNum(root);
    }


    private int getNodesNum(TreeNode cur) {
        if (cur == null) {
            return 0;
        }

        int leftCount = getNodesNum(cur.left);
        int rightCount = getNodesNum(cur.right);
        return leftCount + rightCount + 1;
    }

    /**
     * 针对完全二叉树的解法
     * 满二叉树的节点数为： 2^depth - 1;
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes2(root.right);
        } else {// 右子树是满二叉树
            return (1 << rightDepth) + countNodes2(root.left);
        }


    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }


}
