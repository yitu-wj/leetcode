package com.yitu.leetcode.滑动窗口;

/**
 * https://leetcode.cn/problems/subarray-product-less-than-k/
 */
public class _713_乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int ret = 0;
        int prod = 1;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
