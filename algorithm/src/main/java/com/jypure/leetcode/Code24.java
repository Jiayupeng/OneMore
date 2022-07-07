package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * @author : jiayupeng
 * @date : 2022/7/6/17:11
 */
public class Code24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prep = dummy;
        ListNode pre = dummy.next;
        ListNode cur = pre.next;

        while (cur != null) {
            ListNode next = cur.next;
            prep.next = cur;
            cur.next = pre;
            pre.next = next;
            prep = pre;
            pre = next;
            if (next != null && next.next != null) {
                cur = next.next;
            } else {
                cur = null;
            }
        }

        return dummy.next;

    }

    public ListNode swapPairs1(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }

}
