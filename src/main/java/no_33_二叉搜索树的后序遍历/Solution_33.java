package no_33_二叉搜索树的后序遍历;

/**
 * Created by zhangyue on 2021/3/31 9:27
 */
public class Solution_33 {
    // 这是一棵二叉搜索树，即满足左节点小于根节点，根结点小于右节点
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len == 0 || len == 1) return true;
        return dfs(postorder, 0, len - 1);
    }

    public boolean dfs(int[] postorder, int start, int end) {
        //此时表示已经遍历完，返回true
        if (start >= end) return true;
        // 该位置是根结点的值
        int rootVal = postorder[end];
        //设定数组中左右子树分割点i
        int i = 0;
        for (i = end - 1; i >= start; i--) {
            if (postorder[i] < rootVal) { // 此时找到左右子树的分割点
                // start -> i：都是左子树
                int j = i - 1;
                for (int k = j; k >= start; k--) {
                    // 左子树的值应该都是小于rootVal的
                    if (postorder[k] > rootVal) return false;
                }
            }
        }
        return dfs(postorder, start, i) && dfs(postorder, i + 1, end - 1);
    }
}
