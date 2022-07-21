package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/submissions/
 * @author : jiayupeng
 * @date : 2022/7/21/15:40
 */
public class Code34 {

    public List<Integer> levelOrderBottom(TreeNode root) {
        List<Integer> resList = new LinkedList<>();
        fun1(resList, root);
        return resList;
    }


    /**
     * 层序遍历的时候，判断是否遍历到单层的最后面的元素，如果是，就放进result数组中，随后返回result就可以了。
     * @param node
     */
    public void fun1(List<Integer> resList, TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            int len = que.size();
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                if (len == 1) {
                    resList.add(tmpNode.val);
                }
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
        }
    }



}
