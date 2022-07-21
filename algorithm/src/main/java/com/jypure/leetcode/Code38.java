package com.jypure.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * @author : jiayupeng
 * @date : 2022/7/21/16:19
 */
public class Code38 {

    public Node connect(Node root) {
        Queue<Node> tmpQueue = new LinkedList<>();
        if (root != null){ tmpQueue.add(root);}


        while (tmpQueue.size() != 0){
            int size = tmpQueue.size();

            Node cur = tmpQueue.poll();
            if (cur.left != null) {
                tmpQueue.add(cur.left);
            }
            if (cur.right != null) {
                tmpQueue.add(cur.right);
            }

            for (int index = 1; index < size; index++){
                Node next = tmpQueue.poll();
                if (next.left != null) {
                    tmpQueue.add(next.left);
                }
                if (next.right != null) {
                    tmpQueue.add(next.right);
                }

                cur.next = next;
                cur = next;
            }
        }

        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
