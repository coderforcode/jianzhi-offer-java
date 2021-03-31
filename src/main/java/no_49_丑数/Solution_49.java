package no_49_丑数;

import org.junit.Test;

/**
 * Created by zhangyue on 2021/3/22 12:39
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode/
 */
public class Solution_49 {

    @Test
    public void test() {
        nthUglyNumber(10);
    }

    // 背
    public static int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int temp = 1;

        for (int i = 1; i < n; i++) {
            temp = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = temp;

            if (temp == nums[i2] * 2) {
                i2++;
            }
            if (temp == nums[i3] * 3) {
                i3++;
            }
            if (temp == nums[i5] * 5) {
                i5++;
            }
        }

        return nums[n - 1];
    }
}
