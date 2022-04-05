package com.yitu.leetcode.位运算;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class _231_2的幂 {
    public boolean isPowerOfTwo(int n) {
        return hammingWeight(n) == 1;
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 0x01) == 0x01) count++;
            n >>>= 1;
        }
        return count;
    }
}
