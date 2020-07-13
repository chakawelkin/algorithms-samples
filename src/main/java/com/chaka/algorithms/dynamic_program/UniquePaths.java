package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/unique-paths/">不同路径</a>
 * 1、动态规划
 * {@code {
 *         int[][] dp = new int[m][n];
 *         for (int i = 0; i < m; i++) {
 *             dp[i][0] = 1;
 *         }
 *         for (int i = 0; i < n; i++) {
 *             dp[0][i] = 1;
 *         }
 *         for (int i = 1; i < m; i++) {
 *             for (int j = 1; j < n; j++) {
 *                 dp[i][j] = dp[i][j-1] + dp[i-1][j];
 *             }
 *         }
 *         return dp[m - 1][n - 1];
 *     }}
 *
 *
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[m -1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,2));
    }

}
