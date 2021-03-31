package no_16_数值的整数次方;

import org.junit.Test;

class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2.000, -2147483648));
    }
    public static double myPow(double x, int n) {
        if (x == 1) return x;
        boolean isNegative = false;
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        double res = 1.0;
        while (n > 0) {
            res *= x;
            n--;
        }
        return isNegative == false ? res : 1.0 / res;
    }
}