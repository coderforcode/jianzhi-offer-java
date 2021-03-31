package no_21_调整数组顺序使奇数位于偶数前面;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangyue on 2021/3/30 9:51
 */
public class Solution_21 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        exchange(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public int[] exchange(int[] nums) {
        int n = nums.length;
        int p = 0, q = n - 1;
        while (p < q) {
            while (p < q && nums[p] % 2 == 1) {
                p++;
            }
            while (p < q && nums[q] % 2 == 0) {
                q--;
            }
            if (p < q) {
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
            }
        }
        return nums;
    }
}
