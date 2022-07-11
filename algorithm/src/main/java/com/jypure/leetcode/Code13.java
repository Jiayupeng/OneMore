package com.jypure.leetcode;

/**
 * 反转字符串
 * @author : jiayupeng
 * @date : 2022/7/11/13:47
 */
public class Code13 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right > left) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right > left) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }


}
