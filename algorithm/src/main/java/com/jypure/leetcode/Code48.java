package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 * @author : jiayupeng
 * @date : 2022/8/1/10:55
 */
public class Code48 {

    /**
     * 递归
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root){
        if (root == null) {
            return 0;
        }

        int leftValue = sumOfLeftLeaves(root.left);//左
        int rightValue = sumOfLeftLeaves(root.right);//右

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;//中
        return sum;

    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

}
