package com.yitu.leetcode.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155_最小栈 {
    private Stack<Integer> stack;
    /* 用来存放最小数据 */
    private Stack<Integer> minStack;

    public _155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
    	minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
