package com.yitu.leetcode.数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 */
public class _806_写字符串需要的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        int lineCount = 0;
        int currentLineWidth = 0;
        if (!s.isEmpty()) lineCount++;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (currentLineWidth + width > 100) {
                lineCount++;
                currentLineWidth = 0;
            }
            currentLineWidth += width;
        }
        return new int[]{lineCount, currentLineWidth};
    }

    public static void main(String[] args) {
        int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] ints = new _806_写字符串需要的行数().numberOfLines(widths, s);
        System.out.println(Arrays.toString(ints));
    }
}
