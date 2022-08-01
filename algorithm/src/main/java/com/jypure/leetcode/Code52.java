package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author : jiayupeng
 * @date : 2022/8/1/16:30
 */
public class Code52 {

    Map<Integer, Integer> map;//方便根据数值找位置

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();


        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }


    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        //参数里的范围都是前闭后开
        // 不满足左闭右开，说明没有元素，返回空树
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }

        // 找到后序遍历的最后一个元素在中序遍历中的位置
        int rootIndex = map.get(postorder[postEnd - 1]);

        TreeNode root = new TreeNode(inorder[rootIndex]);
        //保存中序左子树个数，用来确定后序数列的个数
        int lenOfLeft = rootIndex - inBegin;

        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }

}
