package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock">最佳买卖股票时机</a>
 * 一、今日手上无股票
 *  1、昨日就没有持有股票，今天选择继续不持有，所以无股票
 *  2、要么是昨天持有股票，今天卖出了
 *  dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + price[i])
 * 二、手上有股票
 *  1、昨日持有股票，今天不卖，继续持有
 *  2、昨日无股票，今天买入
 *  dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - price[i])
 *
 *  买入时，最大交易次数减一
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, - prices[i]);
        }
        return dp_i_0;
    }

}
