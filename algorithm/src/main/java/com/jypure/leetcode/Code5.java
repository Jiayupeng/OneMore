package com.jypure.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/
 * @author : jiayupeng
 * @date : 2022/7/8/23:31
 */
public class Code5 {

    public static void main(String[] args){
        Code5 code5 = new Code5();
        boolean anagram = code5.isAnagram("car", "rat");
        System.out.println(anagram);

    }

    /**
     * 用map计数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int count = map.get(c) - 1;
            if (count <= 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        if (map.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 用26个元素的数组来计数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
