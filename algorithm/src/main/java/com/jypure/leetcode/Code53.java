package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author : jiayupeng
 * @date : 2022/8/1/17:50
 */
public class Code53 {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd){
        //前闭后开,递归不变量
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        int rootIndex = map.get(preorder[preBegin]);

        TreeNode root = new TreeNode(inorder[rootIndex]);

        int lenOfLeft = rootIndex - inBegin;

        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1, inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }





}
