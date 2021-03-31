package no_22_链表中倒数第K个节点;

import common.ListNode;

/**
 * Created by zhangyue on 2021/3/30 10:18
 * no_22_链表中倒数第K个节点
 */
public class Solution_22 {
    // 两个指针p,q，其中一个指针p先走k个位置，然后两个指针p,q同时走，p到达末尾则q在倒数第k个节点的位置
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head;
        while (k-- != 0) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }

        return q;
    }
}
