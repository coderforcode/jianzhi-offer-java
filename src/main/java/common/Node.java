package common;

/**
 * Created by zhangyue on 2021/3/22 10:35
 */
public class Node {
    public int val;
     public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
