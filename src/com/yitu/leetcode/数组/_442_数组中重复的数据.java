package com.yitu.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 */
public class _442_数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            } else {
                list.add(num);
            }
        }
        return list;
    }
}
