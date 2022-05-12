package com.yitu.leetcode.排序;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reorder-data-in-log-files/
 */
public class _937_重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (str1, str2) -> {
            char c1 = str1.toCharArray()[str1.length() - 1];
            char c2 = str2.toCharArray()[str2.length() - 1];
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String s1 = str1.substring(str1.indexOf(" "));
                String s2 = str2.substring(str2.indexOf(" "));
                if (s1.equals(s2)) {
                    return str1.compareTo(str2);
                }
                return s1.compareTo(s2);
            } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                return 0;
            } else if (Character.isDigit(c1)) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }
}
