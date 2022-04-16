package com.yitu.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/rotate-string/
 */
public class _796_旋转字符串 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
