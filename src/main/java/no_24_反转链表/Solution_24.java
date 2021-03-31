package no_24_反转链表;

import common.ListNode;

/**
 * Created by zhangyue on 2021/3/30 10:23
 * no_24_反转链表
 */
public class Solution_24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = null;
        ListNode p1 = dummy;
        ListNode p2 = head;
        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        return p1;
    }
}
