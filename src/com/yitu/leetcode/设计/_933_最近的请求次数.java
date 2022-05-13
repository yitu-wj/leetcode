package com.yitu.leetcode.设计;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-recent-calls/
 */
public class _933_最近的请求次数 {
    class RecentCounter {
        private Queue<Integer> times;
        private int windowSize;
        public RecentCounter() {
            times = new LinkedList<>();
            windowSize = 3000;
        }

        public int ping(int t) {
            times.offer(t);
            while (times.peek() + windowSize < t) {
                times.poll();
            }
            return times.size();
        }
    }
}
