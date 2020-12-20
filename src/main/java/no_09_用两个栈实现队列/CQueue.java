package no_09_用两个栈实现队列;

import java.util.Stack;

/**
 * Created by zhangyue on 2020/12/20 14:39
 */
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        // 负责尾部添加
        stack1 = new Stack<>();
        // 负责首部删除
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() != 0) {
            return stack2.pop();
        }
        if (stack1.size() == 0) {
            return -1;
        } else {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
