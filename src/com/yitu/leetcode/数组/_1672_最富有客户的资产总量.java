package com.yitu.leetcode.数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 */
public class _1672_最富有客户的资产总量 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            max = Math.max(sum, max);
        }
        return max;
    }
}
