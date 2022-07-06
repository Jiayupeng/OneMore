package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * @author : jiayupeng
 * @date : 2022/7/1/14:35
 */
public class LeetCode206 {



    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;

    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode lastNode = reverseList1(head.next);

        head.next.next = head;
        head.next = null;
        return lastNode;
    }

}
