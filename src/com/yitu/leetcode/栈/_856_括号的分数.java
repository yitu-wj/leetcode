package com.yitu.leetcode.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数 {
    public static int scoreOfParentheses(String s) {
        return scoreOfParentheses(s, 0, s.length());
    }

    public static int scoreOfParentheses(String s, int i, int j) {
        int ans = 0, bal = 0;
        for (int k = i; k < j; k++) {
            bal += s.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1) ans++;
                else ans += 2 * scoreOfParentheses(s, i + 1, k);
                i = k + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = scoreOfParentheses("(()(()))");
        System.out.println(result);
    }
}
