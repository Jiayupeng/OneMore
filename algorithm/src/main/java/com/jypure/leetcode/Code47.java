package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/
 * @author : jiayupeng
 * @date : 2022/7/25/17:49
 */
public class Code47 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);

        return res;
    }

    /**
     * 递归法
     * 前序
     * @param root
     * @param paths
     * @param res
     */
    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        //叶子节点
        if (root.left == null && root.right == null) {
            //输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }

        if (root.left != null) {
            traversal(root.left, paths, res);
            //回溯
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<Object> stack = new Stack<>();
        //节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");

        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            //如果找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }

            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }

        return result;
    }


}
