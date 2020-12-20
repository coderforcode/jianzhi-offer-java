package no_03_数组中的重复数字;

/**
 * Created by zhangyue on 2020/12/20 13:24
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (count[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}
