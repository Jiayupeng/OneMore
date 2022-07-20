package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历，迭代写法，统一写法
 * @author : jiayupeng
 * @date : 2022/7/19/10:32
 */
public class Code31 {

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) {
            st.push(root);
        }

        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                //将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                st.pop();
                // 添加右节点（空节点不入栈）
                if (node.right != null) {
                    st.push(node.right);
                }
                // 添加左节点（空节点不入栈）
                if (node.left != null) {
                    st.push(node.left);
                }
                st.push(node);
                // 中节点访问过，但是还没有处理，加入空节点做为标记。
                st.push(null);
            } else {// 只有遇到空节点的时候，才将下一个节点放进结果集
                // 将空节点弹出
                st.pop();
                // 重新取出栈中元素
                node = st.peek();
                st.pop();
                //加入到结果集
                result.add(node.val);
            }
        }


        return result;

    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();
        if (root != null) {
            st.push(root);
        }

        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                st.pop();
                // 添加右节点（空节点不入栈）
                if (node.right != null) {
                    st.push(node.right);
                }
                // 添加中节点
                st.push(node);
                // 中节点访问过，但是还没有处理，加入空节点做为标记。
                st.push(null);
                // 添加左节点（空节点不入栈
                if (node.left != null) {
                    st.push(node.left);
                }
            } else {// 只有遇到空节点的时候，才将下一个节点放进结果集
                //将空节点弹出
                st.pop();
                //重新取出栈中元素
                node = st.peek();
                st.pop();
                //加入到结果集
                result.add(node.val);
            }
        }
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();
        if (root != null) {
            st.push(root);
        }

        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                //入栈 中、右、左
                st.push(node);
                st.push(null);
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
            } else {
                st.pop();
                node = st.peek();
                st.pop();
                result.add(node.val);

            }
        }

        return result;
    }








}
