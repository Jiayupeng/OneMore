package com.jypure.leetcode;

import com.jypure.ListNode;

/**
 * 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author : jiayupeng
 * @date : 2022/7/8/16:45
 */
public class Code4 {

    //https://leetcode.cn/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
    /**
     * a + b 节点
     * a是环前节点个数，b是环的节点个数
     *
     * f：快指针走过的个数
     * s：慢指针走过的个数
     *
     * f = 2s, fast走的是s的两倍
     * fast比slow多走了n个环的长度，f和s共同走过a，同时在环内重叠，f比s走的多，因此一定是n倍的环的节点个数，也就是nb
     * f = s + nb
     *
     * s = nb;
     *
     * 走到环形入口一共需要 a + nb
     * 而s = nb，那么让s再走a次，就能到达环入口，也就是从头节点走a个节点，和s重合时，就是a的值，也就是环入口的地方
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            //如果快指针为null，或者下一个节点为null，那一定没有环
            if (fast == null || fast.next == null) {
                return null;
            }
            //让快慢指针相遇
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        //再来一个指针，指向head，和慢指针一起移动，直到相遇，就是到达环入口走过的次数
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;

    }

}
