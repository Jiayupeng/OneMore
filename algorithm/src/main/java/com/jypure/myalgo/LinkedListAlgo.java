package com.jypure.myalgo;

/**
 * @author : jiayupeng
 * @date : 2020/9/1/10:24
 */
public class LinkedListAlgo {

    /**
     * 单链表反转
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node cur = list, pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 监测环
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static Node createNode(int value){
        return new Node(value, null);
    }

    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
