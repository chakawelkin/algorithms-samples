package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">买卖股票的最佳时机 II</a>
 * 1、不限交易次数
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0] - prices[i])
 */
public class BestTimeToBuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        int n = prices.length;
//        int[][] dp = new int[n][2];
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }

}