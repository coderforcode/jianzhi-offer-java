package no_18_删除链表的节点;


import common.ListNode;

/**
 * Created by zhangyue on 2021/3/30 9:10
 * no_18_删除链表的节点
 */
public class Solution_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        p.next = head;
        while (p != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
