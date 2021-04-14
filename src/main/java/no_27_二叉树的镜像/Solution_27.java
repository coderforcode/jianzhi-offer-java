package no_27_二叉树的镜像;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by zhangyue on 2021/4/14 16:02
 */
public class Solution_27 {
    public TreeNode mirrorTree(TreeNode root) {
        // 核心在于: 前序遍历，将每个节点的左右节点进行交换，这里的交换不是值的交换，则能达到将整体翻转的效果
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                swap(node);
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
