package com.jypure.leetcode;

/**
 * 151.翻转字符串里的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * @author : jiayupeng
 * @date : 2022/7/11/19:31
 */
public class Code16 {

    public String reverseWords(String s) {
        //去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        //反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        //反转单个单词
        reverseEachWord(sb);

        return sb.toString();

    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }

        while (s.charAt(end) == ' '){
            end--;
        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
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

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }


}
