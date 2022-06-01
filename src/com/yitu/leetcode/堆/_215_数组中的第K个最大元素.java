package com.yitu.leetcode.堆;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}
