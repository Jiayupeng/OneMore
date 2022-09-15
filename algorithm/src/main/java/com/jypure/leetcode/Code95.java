package com.jypure.leetcode;

import java.util.List;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 * @author : jiayupeng
 * @date : 2022/9/14/10:26
 */
public class Code95 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }




}
