package com.jypure.leetcode;

import com.jypure.TreeNode;

import java.util.ArrayList;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * @author : jiayupeng
 * @date : 2022/8/2/19:09
 */
public class Code59 {

    ArrayList<Integer> resList;

    int maxCount;

    int count;

    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;


    }

    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }

        findMode1(root.left);

        int rootValue = root.val;

        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }

        //更新结果以及maxCount;
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }

        pre = root;

        findMode1(root.right);

    }

}
