package com.yitu.leetcode.位运算;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class _191_位1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 0x01) == 0x01) count++;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = Integer.valueOf("111111111111111111111111", 2).toString();
        System.out.println(s);
    }
}
