package no_13_机器人的运动范围;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * Created by zhangyue on 2020/12/26 16:19
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(movingCount(16, 8, 4));
    }

    // 使用bfs， 对于数据量较多的情况，dfs可能会存在栈溢出
    // dfs 适合判断有没有的情况，bfs 适合计算出具体数值的情况
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];

        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair<>(0, 0));

        int res = 0;
        while (queue.size() != 0) {
            final Pair<Integer, Integer> pair = queue.poll();
            if (getSum(pair) > k || visited[pair.getKey()][pair.getValue()]) continue;
            res++;
            visited[pair.getKey()][pair.getValue()] = true;
            int[] dx = new int[]{-1, 0, 1, 0};
            int[] dy = new int[]{0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int x = pair.getKey() + dx[i];
                int y = pair.getValue() + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    queue.offer(new Pair(x,y));
                }
            }
        }
        return res;
    }

    public int getSum(Pair<Integer, Integer> pair) {
        return getSingleSum(pair.getKey()) + getSingleSum(pair.getValue());
    }

    public int getSingleSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
