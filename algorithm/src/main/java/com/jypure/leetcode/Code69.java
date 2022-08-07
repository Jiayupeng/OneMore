package com.jypure.leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 * @author : jiayupeng
 * @date : 2022/8/7/12:51
 */
public class Code69 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int start = 0;
        int count = 0;

        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

}
