package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * @author : jiayupeng
 * @date : 2022/6/27/14:26
 */
public class LeetCode203 {


    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        while (head.val == val) {
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val != val) {
                cur = cur.next;
                pre = cur;
                continue;
            }

            pre.next = cur.next;
            cur = cur.next;
        }
        return head;

    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode cur = dummyNode.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummyNode.next;

    }



}
