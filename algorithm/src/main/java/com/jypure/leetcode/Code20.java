package com.jypure.leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author : jiayupeng
 * @date : 2022/7/13/15:05
 */
public class Code20 {

    public static class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        /**
         * 进栈
         * @param x
         */
        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            dumpstackIn();
            return stackOut.pop();
        }

        public int peek() {
            dumpstackIn();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        /**
         * 如果stackOut为空，那么将stackIn中的元素全部放到stackOut
         */
        private void dumpstackIn(){
            if (!stackOut.isEmpty()) {
                return;
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

}
