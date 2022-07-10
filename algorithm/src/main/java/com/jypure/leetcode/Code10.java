package com.jypure.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 * https://leetcode.cn/problems/ransom-note/submissions/
 * @author : jiayupeng
 * @date : 2022/7/10/23:31
 */
public class Code10 {

    /**
     * map解法
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = magazine.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            Integer count = map.get(c) - 1;
            if (count <= 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return true;
    }

    /**
     * 数组解法
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] code = new int[26];

        for (char c : magazine.toCharArray()) {
            code[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            code[c - 'a'] -= 1;
        }

        for (int i : code) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }


}
