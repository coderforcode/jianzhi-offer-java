package no_08_用两个队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangyue on 2020/12/20 14:54
 */
class MyStack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(T data) {
        if (!queue2.isEmpty())
            queue2.offer(data);
        else
            queue1.offer(data);
    }

    public T pop() {
        if (!queue2.isEmpty()) {
            int size = queue2.size();
            //重点在于 size - 1，
            for (int i = 0; i < size - 1; i++)
                queue1.offer(queue2.poll());
            return queue2.poll();
        } else if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++)
                queue2.offer(queue1.poll());
            return queue1.poll();
        } else
            return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
