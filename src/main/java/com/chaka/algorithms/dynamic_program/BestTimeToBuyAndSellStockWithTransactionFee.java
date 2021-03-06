package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/"></a>
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,dp_i_0 - prices[i] - fee);
        }
        return dp_i_0;
    }

}