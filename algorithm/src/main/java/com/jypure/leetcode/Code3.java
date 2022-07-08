package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * 链表相交
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * @author : jiayupeng
 * @date : 2022/7/8/14:55
 */
public class Code3 {

    /**
     * 牛逼
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

}
