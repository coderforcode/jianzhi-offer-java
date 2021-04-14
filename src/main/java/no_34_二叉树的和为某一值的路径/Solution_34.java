package no_34_二叉树的和为某一值的路径;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyue on 2021/3/31 9:57
 */
public class Solution_34 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    // 回溯法
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backTracking(root, target);
        return ans;
    }

    public void backTracking(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;

        if (root.left == null && root.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }

        backTracking(root.left, target);
        backTracking(root.right, target);
        path.remove(path.size() - 1);
    }
}
