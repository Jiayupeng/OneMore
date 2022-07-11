package com.jypure.leetcode;


/**
 * 反转字符串 II
 * https://leetcode.cn/problems/reverse-string-ii/submissions/
 * @author : jiayupeng
 * @date : 2022/7/11/14:32
 */
public class Code14 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }

        return new String(chars);


    }

}
