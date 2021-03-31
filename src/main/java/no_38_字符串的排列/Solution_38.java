package no_38_字符串的排列;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyue on 2021/3/22 10:51
 */
public class Solution_38 {

    @Test
    public void test() {
        permutation("abc");

    }

    List<List<Character>> ans = new ArrayList<>();
    List<Character> path = new ArrayList<>();

    public String[] permutation(String s) {
        final char[] chaos = s.toCharArray();
        backTracking(chaos, new boolean[chaos.length]);
        ans.forEach(System.out::println);
        return null;
    }

    public void backTracking(char[] chaos, boolean[] used) {
        if (path.size() == chaos.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < chaos.length; i++) {
            if (used[i] == true) continue;
            path.add(chaos[i]);
            used[i] = true;
            backTracking(chaos, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
