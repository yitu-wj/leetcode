package com.yitu.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
public class _821_字符的最短距离 {
    public int[] shortestToChar(String s, char c) {
        int[] shortest = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            shortest[i] = chars[i] == c ? 0 : -1;
        }
        for (int i = 0; i < shortest.length; i++) {
            int sc = shortest[i];
            if (sc == 0) continue;
            // 从左边开始寻找值为0的数据
            int leftIndex = i - 1;
            int lefMin = Integer.MAX_VALUE;
            while (leftIndex >= 0) {
                if (shortest[leftIndex] == 0) {
                    lefMin = Math.abs(i - leftIndex);
                    break;
                }
                leftIndex--;
            }
            // 从右边开始寻找值为0的数据
            int rightIndex = i + 1;
            int rightMin = Integer.MAX_VALUE;
            while (rightIndex < shortest.length) {
                if (shortest[rightIndex] == 0) {
                    rightMin = Math.abs(i - rightIndex);
                    break;
                }
                rightIndex++;
            }
            shortest[i] = Math.min(lefMin, rightMin);
        }
        return shortest;
    }
}
