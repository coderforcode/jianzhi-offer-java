package no_35_复杂链表的复制;

import common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyue on 2021/3/31 10:13
 */
public class Solution_35 {
    // map + 链表
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }

        p = head;
        while (p != null) {
            Node newNode = map.get(p);
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }

            if (p.random != null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }

        return map.get(head);
    }
}
