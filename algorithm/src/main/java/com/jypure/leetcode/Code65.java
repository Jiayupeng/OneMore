package com.jypure.leetcode;

import com.jypure.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * @author : jiayupeng
 * @date : 2022/8/3/22:25
 */
public class Code65 {

    /**
     * 直接用数组中间的元素作为根节点，自动就是平衡的。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }

        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

}
