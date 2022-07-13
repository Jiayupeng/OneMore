package com.jypure.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * @author : jiayupeng
 * @date : 2022/7/13/15:49
 */
public class Code21 {

    class MyStack {

        Deque<Integer> que1;

        public MyStack() {
            que1 = new ArrayDeque<>();
        }

        public void push(int x) {
            que1.addLast(x);
        }

        public int pop() {
            int size = que1.size();
            size--;
            //把除队尾外的其他元素重新拿出来再放进队列中，这样最后一个元素就排到队首了。
            while (size-- > 0) {
                que1.addLast(que1.peekFirst());
                que1.pollFirst();
            }

            int res = que1.pollFirst();
            return res;
        }

        public int top() {
            return que1.peekLast();
        }

        public boolean empty() {
            return que1.isEmpty();
        }
    }
}
