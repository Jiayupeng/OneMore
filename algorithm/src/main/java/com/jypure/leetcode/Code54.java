package com.jypure.leetcode;

import com.jypure.TreeNode;

import org.graalvm.compiler.graph.NodeUnionFind;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 * @author : jiayupeng
 * @date : 2022/8/1/19:49
 */
public class Code54 {

    /**
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }

        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        //最大值所在位置
        int maxIndex = leftIndex;

        //最大值
        int maxVal = nums[maxIndex];

        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);

        return root;
    }

}
