package no_07_重建二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyue on 2020/12/20 14:22
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preorderLength = preorder.length, inorderLength = inorder.length;
        if (preorderLength == 0) {
            return null;
        }
        // 存储inorder的下标，便于后续查找
        Map<Integer, Integer> pos = new HashMap();
        for (int i = 0; i < inorderLength; i++) {
            pos.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorderLength - 1, inorder, 0, inorderLength, pos);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> pos) {
        // 重要，返回的条件
        if (preL > preR) return null;
        int pivot = pos.get(preorder[preL]);

        TreeNode root = new TreeNode(inorder[pivot]);
        root.left = buildTreeHelper(preorder, preL + 1, pivot - inL + preL, inorder, inL, pivot - 1, pos);
        root.right = buildTreeHelper(preorder, pivot - inL + preL + 1, preR, inorder, pivot + 1, inR, pos);
        return root;
    }
}
