package com.yitu.leetcode.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class _136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
