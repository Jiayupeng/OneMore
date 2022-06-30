package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * @author : jiayupeng
 * @date : 2022/6/30/18:02
 */
public class LeetCode707 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.deleteAtIndex(0);

    }

    public static class MyLinkedList{

        int size;
        ListNode dummy;

        public MyLinkedList() {
            dummy = new ListNode(-1);
            size = 0;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode cur = dummy;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            ListNode pre = dummy;

            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

            ListNode next = pre.next;
            ListNode node = new ListNode(val);
            pre.next = node;
            node.next = next;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            ListNode pre = dummy;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

            ListNode next = pre.next;
            pre.next = next.next;
            size--;

        }
    }


}
