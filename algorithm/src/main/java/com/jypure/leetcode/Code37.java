package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * @author : jiayupeng
 * @date : 2022/7/21/16:15
 */
public class Code37 {

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(max);
        }
        return result;
    }

}
