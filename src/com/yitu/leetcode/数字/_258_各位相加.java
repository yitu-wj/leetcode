package com.yitu.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/add-digits/
 */
public class _258_各位相加 {
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        int i = new _258_各位相加().addDigits(38);
        System.out.println(i);
    }
}
