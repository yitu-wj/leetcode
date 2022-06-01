package com.yitu.leetcode.堆;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 */
public class _703_数据流中的第K大元素 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int x : nums) {
                add(x);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
