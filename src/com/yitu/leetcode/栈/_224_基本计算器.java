package com.yitu.leetcode.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class _224_基本计算器 {
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                // 开始出栈
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                int calcResult = calculateNoBrackets(sb.toString());
                // 结果可能为负数，需要改变符号
                if (calcResult < 0 && !stack.isEmpty()) {
                    int operator = stack.pop();
                    if (operator == '-') {
                        calcResult = Math.abs(calcResult);
                        stack.push('+');
                    }
                    if (operator == '+') {
                        calcResult = Math.abs(calcResult);
                        stack.push('-');
                    }
                }
                for (char c1 : (calcResult + "").toCharArray()) {
                    stack.push(c1);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(isNumeric(sb.toString())) return Integer.parseInt(sb.toString());
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        int result = calculateNoBrackets(sb.toString());
        return result;
    }

    public int calculateNoBrackets(String s) {
        if (isNumeric(s)) return Integer.parseInt(s);
        Deque<Integer> deque = new LinkedList<>();
        int value = 0;
        char[] chars = s.toCharArray();
        for (int k = 0; k < chars.length; k++) {
            int c = chars[k];
            if (Character.isDigit(c)) {
                value = value * 10 + (c - '0');
            } else {
                deque.offer(value);
                deque.offer(c);
                value = 0;
            }
        }
        deque.add(value);
        while (deque.size() >= 3) {
            int val1 = deque.poll();
            int operator = deque.poll();
            int val2 = deque.poll();
            deque.offerFirst(calculate(val1, val2, operator));
        }
        int val = deque.poll();
        return val;
    }

    public int calculate(int a, int b, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = (a + b);
                break;
            case '-':
                result = (a - b);
                break;
            case '*':
                result = (a * b);
                break;
            case '/':
                result = (a / b);
                break;
        }
        return result;
    }

    public boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        String s1 = "2+(2+1-2)+5";
        String s2 = "(1+(4+5+2)-3)+(6+8)";
        String s3 = "(5-(1+(5)))";
        String s4="- (3 - (- (4 + 5) ) )";
        int result1 = new _224_基本计算器().calculate(s1);
        int result2 = new _224_基本计算器().calculate(s2);
        int result3 = new _224_基本计算器().calculate(s3);
        int result4 = new _224_基本计算器().calculate(s4);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
