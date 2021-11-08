package com.yitu.队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int ri = 0; ri < nums.length; ri++) {
            // 只要nums[队尾] <= num[i], 就删除队尾
            while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 将i加到队尾
            deque.addLast(ri);
            // 检查队头的合法性
            int li = ri - k + 1;
            if (li < 0) continue;
            if (deque.peekFirst() < li) {
                // 队头不合法（失效，不在滑动窗口索引范围内）
                deque.removeFirst();
            }
            // 设置窗口的最大值
            maxes[li] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}
