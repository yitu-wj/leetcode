package com.yitu.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/teemo-attacking/
 */
public class _495_提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int lastTime = 0;
        int preLastTime = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            lastTime = timeSeries[i] + duration - 1;
            result += lastTime - timeSeries[i] + 1;
            if (i > 0 && timeSeries[i] <= preLastTime) {
                result = result - (preLastTime - timeSeries[i]) - 1;
            }
            preLastTime = lastTime;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] timeSeries = new int[]{1, 2};
        int duration = 2;
        int result = new _495_提莫攻击().findPoisonedDuration(timeSeries, duration);
        System.out.println(result);
    }
}
