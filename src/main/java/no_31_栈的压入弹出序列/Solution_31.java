package no_31_栈的压入弹出序列;

import java.util.Stack;

/**
 * Created by zhangyue on 2021/3/30 11:30
 * no_31_栈的压入、弹出序列
 */
public class Solution_31 {
    // 模拟出入栈的操作, 边压栈边判断
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        if (n == 0 || popped.length == 0) return true;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.add(pushed[i]);
            while (j < popped.length && !stack.isEmpty() && popped[j] == stack.peek()) {
                j++;
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
