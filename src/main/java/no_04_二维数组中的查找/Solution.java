package no_04_二维数组中的查找;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                i--;
            } else{
                j++;
            }
        }
        return false;
    }
}