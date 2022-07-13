package com.jypure.leetcode;

import java.util.ArrayDeque;

/**
 *  删除字符串中的所有相邻重复项
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/submissions/
 * @author : jiayupeng
 * @date : 2022/7/13/17:14
 */
public class Code23 {

    public String removeDuplicates(String s) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }

}
