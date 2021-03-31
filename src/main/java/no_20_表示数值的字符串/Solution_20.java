package no_20_表示数值的字符串;

/**
 * Created by zhangyue on 2021/3/30 9:22
 * no_20_表示数值的字符串
 */
public class Solution_20 {
    // todo，抄的
    // 需要考虑的问题实在太多了
    public boolean isNumber(String s) {
        int p = 0, q = s.length() - 1;
        // 1. 去除空格
        while (p <= q && s.charAt(p) == ' ') p++;
        while (p <= q && s.charAt(q) == ' ') q--;
        if (p > q) return false;

        // 截取一段
        s = s.substring(p, q + 1);
        // 2.判断正负号
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        // 3. 判断 点，同时 如果s的长度为1，则返回false
        if (s.isEmpty() || (s.charAt(0) == '.' && s.length() == 1)) return false;

        char[] chaos = s.toCharArray();
        int dot = 0, e = 0;
        for (int i = 0; i < chaos.length; i++) {
            if (chaos[i] >= '0' && chaos[i] <= '9') {
                continue;
            } else if (chaos[i] == '.') {
                dot++;
                // 不可能存在两个dot 或是 e
                if (dot > 1 || e > 0) return false;
            } else if (chaos[i] == 'e' || chaos[i] == 'E') {
                e++;
                if (i == 0 || i == chaos.length - 1 || e > 1 || chaos[i - 1] == '.' && i == 1) return false;
                if (chaos[i + 1] == '+' || chaos[i + 1] == '-') {
                    if (i + 2 == chaos.length) return false;
                    i++;
                }
            } else return false;
        }
        return true;
    }
}
