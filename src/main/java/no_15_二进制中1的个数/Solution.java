package no_15_二进制中1的个数;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((1 & n) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}