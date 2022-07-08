package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * @author : jiayupeng
 * @date : 2022/7/7/09:35
 */
public class Code19 {


    /**
     * 让快慢指针间隔n个位置
     * 让快慢指针间隔n+1个位置，这样当快指针移动到末尾的时候，慢指针刚好在要删除的节点前一个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;


    }
}
