package com.yitu.leetcode.位运算;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class _461_汉明距离 {
    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
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
