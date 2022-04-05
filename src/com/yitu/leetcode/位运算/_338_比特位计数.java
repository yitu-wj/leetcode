package com.yitu.leetcode.位运算;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class _338_比特位计数 {
    public int[] countBits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int count = hammingWeight(i);
            list.add(count);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 0x01) == 0x01) count++;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] result = new _338_比特位计数().countBits(5);
        System.out.println(Arrays.toString(result));
    }
}
