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
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

}