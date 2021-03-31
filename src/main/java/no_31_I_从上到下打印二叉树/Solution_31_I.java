package no_31_I_从上到下打印二叉树;

import common.TreeNode;

import java.util.*;

/**
 * Created by zhangyue on 2021/3/31 9:04
 * no_31_I_从上到下打印二叉树
 */
public class Solution_31_I {
    // 层次遍历，利用队列
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    if (tmp.left != null) queue.add(tmp.left);
                    if (tmp.right != null) queue.add(tmp.right);
                    ans.add(tmp.val);
                }
            }
        }
       return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
