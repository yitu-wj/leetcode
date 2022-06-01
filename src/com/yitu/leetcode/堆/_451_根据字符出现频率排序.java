package com.yitu.leetcode.堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/sort-characters-by-frequency/
 */
public class _451_根据字符出现频率排序 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Letter> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Letter(entry.getKey(), entry.getValue()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            stringBuilder.append(queue.remove());
        }
        return stringBuilder.toString();
    }

    static class Letter {
        char c;
        int count;

        public Letter(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.valueOf(c).repeat(Math.max(0, count));
        }
    }

    public static void main(String[] args) {
        String s = new _451_根据字符出现频率排序().frequencySort("raaeaedere");
        System.out.println(s);
    }
}
