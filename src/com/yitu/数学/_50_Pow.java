package com.yitu.数学;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class _50_Pow {
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow2(x, n >> 1);
        half *= half;
        // 是否为奇数
        return ((n & 1) == 1) ? (half * x) : half;
    }

    public double myPow(double x, int n) {
        long y = (n < 0) ? -((long) n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制是1，就累乘上x
                res *= x;
            }
            x *= x;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return (n < 0) ? (1 / res) : res;
    }
}
