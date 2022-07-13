package com.jypure.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @author : jiayupeng
 * @date : 2022/7/13/17:21
 */
public class Code24 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 / pop1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();

    }

}
