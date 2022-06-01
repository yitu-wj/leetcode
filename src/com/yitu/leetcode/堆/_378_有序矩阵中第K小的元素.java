package com.yitu.leetcode.堆;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class _378_有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] ints : matrix) {
            for (int i : ints) {
                queue.add(i);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            queue.remove();
        }
        return queue.peek();
    }
}
