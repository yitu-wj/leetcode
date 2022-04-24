package com.yitu.leetcode.位运算;

/**
 * https://leetcode-cn.com/problems/binary-gap/
 */
public class _868_二进制间距 {
    public int binaryGap(int n) {
        int lastIndex = -1;
        int maxGap = 0;
        for (int i = 0; n != 0; i++) {
            if ((n & 0x01) == 0x01) {
                if (lastIndex == -1) {
                }
                else {
                    maxGap = Math.max(maxGap, Math.abs(lastIndex - i));
                }
                lastIndex = i;
            }
            n >>>= 1;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int i = new _868_二进制间距().binaryGap(5);
        System.out.println(i);
    }
}
