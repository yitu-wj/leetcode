package com.yitu.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class _118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(1);
        row2.add(1);
        row2.add(1);
        if (numRows == 1) {
            result.add(row1);
            return result;
        }
        result.add(row1);
        result.add(row2);
        if (numRows == 2) return result;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            List<Integer> lastRow = result.get(result.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                newRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new _118_杨辉三角().generate(30);
        System.out.println(result);
    }
}
