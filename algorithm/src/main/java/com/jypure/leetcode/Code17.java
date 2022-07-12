package com.jypure.leetcode;

/**
 * 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author : jiayupeng
 * @date : 2022/7/12/11:17
 */
public class Code17 {

    public String reverseLeftWords(String s, int n) {
        if (s.length() <= n) {
            return s;
        }
        String substring = s.substring(0, n);
        String substring1 = s.substring(n);
        return substring1 + substring;
    }

    public String reverseLeftWords1(String s, int n) {
        if (s.length() <= n) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);
        return sb.reverse().toString();
    }




    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }




}
