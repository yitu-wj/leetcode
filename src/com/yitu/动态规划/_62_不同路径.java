package com.yitu.动态规划;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class _62_不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int uniquePaths = new _62_不同路径().uniquePaths(3, 7);
        System.out.println(uniquePaths);
    }
}
