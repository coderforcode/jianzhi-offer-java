package no_12_矩阵中的路径;

/**
 * Created by zhangyue on 2020/12/26 15:44
 */
class Solution {
    // 深度遍历dfs + 剪枝
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 深度遍历（递归版）
    public boolean dfs(char[][] board, int x, int y, int u, String word) {
        // 剪枝
        // 判断，当遍历到的数组元素不是我们想要的，直接返回
        if (board[x][y] != word.charAt(u)) {
            return false;
        }

        if (u == word.length() - 1) return true;
        char t = board[x][y];
        // 解决被遍历过的点不能再被遍历
        board[x][y] = '*';
        // 移动顺序， 上右下左
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        // 上右下左 移动元素，所以循环次数是4
        for (int k = 0; k < 4; k++) {
            int i = x + dx[k];
            int j = y + dy[k];
            if (0 <= i && i < board.length && 0 <= j && j < board[0].length) {
                if (dfs(board, i, j, u + 1, word)) {
                    return true;
                }
            }
        }
        board[x][y] = t;
        return false;
    }
}
