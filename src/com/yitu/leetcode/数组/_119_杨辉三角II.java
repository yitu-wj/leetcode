package com.yitu.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class _119_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(1);
        row2.add(1);
        row2.add(1);
        if (rowIndex == 1) {
            return row1;
        }
        result.add(row1);
        result.add(row2);
        if (rowIndex == 2) return row2;
        for (int i = 3; i <= rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            List<Integer> lastRow = result.get(result.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                newRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result.get(result.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> row = new _119_杨辉三角II().getRow(2);
        System.out.println(row);
    }
}
