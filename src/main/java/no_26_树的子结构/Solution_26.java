package no_26_树的子结构;

import common.TreeNode;

/**
 * Created by zhangyue on 2021/3/30 10:43
 * no_26_树的子结构
 */
public class Solution_26 {
    // 递归
    //https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
    public boolean isSubStructure(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (isPart(root1, root2)) {
            return true;
        }
        return isSubStructure(root1.left, root2) || isSubStructure(root1.right, root2);
    }

    private boolean isPart(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null || root1.val != root2.val) return false;
        return isPart(root1.left, root2.left) && isPart(root1.right, root2.right);

    }
}
