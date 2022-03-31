package com.yitu.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 */
public class _693_交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int lastBit = -1;
        while (n != 0) {
            int currentBit = n & 0x01;
            if (lastBit == -1) {
                n = n >> 1;
                lastBit = currentBit;
                continue;
            }
            if (lastBit == currentBit) return false;
            n = n >> 1;
            lastBit = currentBit;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new _693_交替位二进制数().hasAlternatingBits(11);
        System.out.println(result);
    }
}
