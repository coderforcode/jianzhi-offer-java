package no_31_III_从上到下打印二叉树III;

import common.ListNode;
import common.TreeNode;

import java.util.*;

/**
 * Created by zhangyue on 2021/3/31 9:16
 */
public class Solution_31_III {
    // 记录层高，对于奇数层，将其元素反转即可
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ansTmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    if (tmp.left != null) queue.add(tmp.left);
                    if (tmp.right != null) queue.add(tmp.right);
                    ansTmp.add(tmp.val);
                }
            }
            if (level % 2 == 1) Collections.reverse(ansTmp);
            ans.add(ansTmp);
            level++;
        }
        return ans;
    }
}
