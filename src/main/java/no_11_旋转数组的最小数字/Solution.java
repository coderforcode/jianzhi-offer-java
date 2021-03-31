package no_11_旋转数组的最小数字;

/**
 * Created by zhangyue on 2020/12/26 15:41
 */
public class Solution {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
