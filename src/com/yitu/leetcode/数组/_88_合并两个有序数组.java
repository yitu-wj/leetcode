package com.yitu.leetcode.数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class _88_合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 = [1,3,5,0,0,0]    m = 3
        // nums2 = [2,4,6]          n = 3
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;

        while (i2 >= 0) {
            if (i1 >= 0 && nums2[i2] < nums1[i1]) {
                nums1[cur--] = nums1[i1--];
            } else { // // i1 < 0 || nums2[i2] >= nums1[i1]
                nums1[cur--] = nums2[i2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
        int n = 3;
        merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
}
