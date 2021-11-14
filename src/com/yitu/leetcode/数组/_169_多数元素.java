package com.yitu.leetcode.数组;


/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class _169_多数元素 {
    public int majorityElement(int[] nums) {
        int cnt = 0, major = 0;
        for (int num : nums) {
            if (cnt == 0) {
                major = num;
                cnt = 1;
            } else {
                cnt += (major == num ? 1 : -1);
            }
        }
        return major;
    }
}
