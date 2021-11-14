package com.yitu.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class _42_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int lastIdx = height.length - 2;
        int[] leftMaxes = new int[height.length];
        for (int i = 1; i <= lastIdx; i++) {
            leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i - 1]);
        }

        int[] rightMaxes = new int[height.length];
        for (int i = lastIdx; i >= 1; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
        }

        // 遍历每一根柱子，看看每一根柱子上能放多少水
        int water = 0;
        for (int i = 1; i <= lastIdx; i++) {
            // 求出左边最大、右边最大中的较小者
            int min = Math.min(leftMaxes[i], rightMaxes[i]);
            // 说明这根柱子不能放水
            if (min <= height[i]) continue;
            // 说明这根柱子不能放水
            water += min - height[i];
        }
        return water;
    }
}
