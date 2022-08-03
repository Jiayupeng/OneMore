package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * @author : jiayupeng
 * @date : 2022/8/3/15:01
 */
public class Code63 {

    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root, key);
        return root;
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = delete(root.left, key);
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {//要删除的节点，左孩子为空，右孩子补位，作为根节点返回
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //左右孩子都不为空
            //用右孩子最左边节点替换要删除的节点，然后删除右孩子最左边的节点
            //实质就是把左孩子，挂在右孩子最左边的节点下面，作为最左边孩子的左孩子。
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = tmp.val;//没有删除root，只是把root的val换了，所以左孩子还挂在root下面。
            root.right = delete(root.right, tmp.val);
        }
        return root;
    }



}
