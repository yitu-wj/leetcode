package com.yitu.leetcode.位运算;

/**
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class _762_二进制表示中质数个计算置位 {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(countBitOne(i))) count++;
        }
        return count;
    }

    public int countBitOne(int number) {
        int count = 0;
        while (number > 0) {
            if ((number & 0x01) == 0x01) count++;
            number >>= 1;
        }
        return count;
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int result1 = new com.yitu.leetcode.位运算._762_二进制表示中质数个计算置位().countPrimeSetBits(10, 15);
//        int result1 = new _762_二进制表示中质数个计算置位().countBitOne(9);
//        int result2 = new _762_二进制表示中质数个计算置位().countBitOne(9);
//        int result3 = new _762_二进制表示中质数个计算置位().countBitOne(9);
//        int result4 = new _762_二进制表示中质数个计算置位().countBitOne(9);

        System.out.println(result1);
//        System.out.println(result2);
    }
}
