package com.jypure.leetcode;

/**
 * 实现 strStr()
 * https://leetcode.cn/problems/implement-strstr/
 * @author : jiayupeng
 * @date : 2022/7/12/11:29
 */
public class Code18 {

    /**
     * 暴力解法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        int lenS = haystack.length();
        int lenP = needle.length();

        for (int i = 0; i <= lenS - lenP; i++) {
            boolean flag = true;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }
        return -1;
    }


    /**
     * kmp算法
     * https://www.zhihu.com/question/21923021
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        //失配位置下标之前的位置是已经匹配上的，这一部分匹配上的字符串，找到前缀和后缀相等的个数，比如 aabaa, 前缀aa和后缀aa相同，
        //那么next数组里这个下标位置的值就是2
        //next数组的定义，记录了模式串每个下标位置，最长的相等前后缀：
        //定义 “k-前缀” 为一个字符串的前 k 个字符； “k-后缀” 为一个字符串的后 k 个字符。k 必须小于字符串长度。
        //next[x] 定义为： P[0]~P[x] 这一段字符串，使得k-前缀恰等于k-后缀的最大的k.定义 “k-前缀” 为一个字符串的前 k 个字符； “k-后缀” 为一个字符串的后 k 个字符。k 必须小于字符串长度。
        //next[x] 定义为： P[0]~P[x] 这一段字符串，使得k-前缀恰等于k-后缀的最大的k.

        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i<haystack.length();i++){
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }

            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            if(j==needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;


    }

    private void getNext(int[] next, String s) {
        //j是公共前后缀长度，j指向前缀
        int j = -1;
        next[0] = j;//向右移一个
        //i从1开始，i是后缀
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    public int strStr2(String haystack, String needle){
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext1(next, needle);

        int j = -1;//j是needle的下标
        for (int i = 0; i < haystack.length(); i++) {
            //处理不同的情况
            while (j >= 0 && haystack.charAt(i) != needle.charAt(i)) {
                j = next[j];
            }
            //处理相同的情况
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            //正确的结果,j走到最后
            if (j == needle.length() - 1) {
                //用i减去needle的长度
                return i - needle.length() + 1;
            }
        }

        return -1;
    }

    private void getNext1(int[] next, String needle) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            next[i] = j;
        }

    }


}
