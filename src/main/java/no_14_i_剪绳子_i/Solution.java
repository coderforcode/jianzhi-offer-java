package no_14_剪绳子;

/**
 * Created by zhangyue on 2020/12/26 20:18
 */
class Solution {
    // 数学方法
    // 当乘数是 3 或是 4 的时候，可以得到最大乘积
    public int cuttingRope(int n) {
        if (n == 1 || n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int multi = 1;
        int count = n / 3;
        // 此时余数可以组成一个4， a * 4 > a * 3 + 1
        if (n % 3 == 1) {
            count--;
        }
        for (int i = 0; i < count; i++) {
            multi *= 3;
        }
        if (n % 3 == 1)
            return multi * 4;

        if (n % 3 == 2) {
            return multi *= 2;
        }
        return multi;
    }
}
