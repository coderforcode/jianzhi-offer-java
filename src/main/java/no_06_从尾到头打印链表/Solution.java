package no_06_从尾到头打印链表;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}


class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode p1 = head;
        int length = 0;
        while (p1 != null) {
            length++;
            p1 = p1.next;
        }
        int[] array = new int[length];
        p1 = head;
        length--;
        while (p1 != null) {
            array[length--] = p1.val;
            p1 = p1.next;
        }
        return array;
    }
}