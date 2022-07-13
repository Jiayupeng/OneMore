package com.jypure.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/submissions/
 * @author : jiayupeng
 * @date : 2022/7/13/16:02
 */
public class Code22 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if (stack.isEmpty()) {
                return false;
            }
            if (c == ')') {
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            }
            if (c == ']') {
                Character pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            }
            if (c == '}') {
                Character pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;


    }

    public boolean isValid1(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }

}
