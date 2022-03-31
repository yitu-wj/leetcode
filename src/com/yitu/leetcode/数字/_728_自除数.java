package com.yitu.leetcode.数字;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 */
public class _728_自除数 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if (left > right) return list;
        for (int i = left; i <= right; i++) {
            if (selfDividingNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean selfDividingNumber(int number) {
        int newNumber = number;
        while (newNumber != 0) {
            int dividing = newNumber % 10;
            newNumber = newNumber / 10;
            if (dividing == 0) return false;
            if (number % dividing != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> result = new _728_自除数().selfDividingNumbers(47, 85);
        System.out.println(result);
    }
}
