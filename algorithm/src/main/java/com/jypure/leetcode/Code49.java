package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @author : jiayupeng
 * @date : 2022/8/1/13:40
 */
public class Code49 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

}
