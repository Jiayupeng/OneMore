package com.jypure;

/**
 * @author : jiayupeng
 * @date : 2022/6/30/17:24
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int x){val = x;}
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }


}
