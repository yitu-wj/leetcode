package com.yitu.leetcode.堆;

import java.util.*;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Number> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Number(entry.getKey(), entry.getValue()));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove().digit;
        }
        return result;
    }

    static class Number {
        int digit;
        int count;

        public Number(int digit, int count) {
            this.digit = digit;
            this.count = count;
        }
    }
}
