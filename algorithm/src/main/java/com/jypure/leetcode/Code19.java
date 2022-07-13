package com.jypure.leetcode;

/**
 * 重复的子字符串
 * https://leetcode.cn/problems/repeated-substring-pattern/submissions/
 * @author : jiayupeng
 * @date : 2022/7/13/14:44
 */
public class Code19 {

    public boolean repeatedSubstringPattern(String s) {

        if (s.equals("")) {
            return false;
        }

        int len = s.length();
        //原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        //构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            //不相等
            while (j > 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            //相等
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }

}
