package com.jypure.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  N 叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 * @author : jiayupeng
 * @date : 2022/7/25/15:21
 */
public class Code44 {

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len-- > 0) {
                Node node = que.poll();
                if (node.children != null && !node.children.isEmpty()) {
                    for (Node child : node.children) {
                        if (child != null) {
                            que.offer(child);
                        }
                    }
                }
            }
            depth++;
        }

        return depth;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                depth = Math.max(depth, maxDepth1(child));
            }
        }
        return depth + 1;
    }



    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }



}
