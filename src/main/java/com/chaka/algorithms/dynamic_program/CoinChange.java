package com.chaka.algorithms.dynamic_program;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/coin-change/">零钱兑换</a>
 *  1、贪心 + dfs
 *  2、动态规划  -- 自顶向下和自底向上
 *     -- dp数组的迭代解法，使用dp table来消除重叠子问题
 *     {@code
 *     public int coinChange(int[] coins, int amount) {
 *         int[] dp = new int[amount + 1];
 *         Arrays.fill(dp,amount + 1);
 *         dp[0] = 0;
 *         for (int i = 1; i < dp.length; i++) {
 *             for (int coin : coins) {
 *                 if (i - coin < 0){
 *                     continue;
 *                 }
 *                 //递归，选择硬币数最少的那种
 *                 dp[i] = Math.min(dp[i],1 + dp[i - coin]);
 *             }
 *         }
 *         return dp[amount] == amount + 1 ? -1 : dp[amount];
 *     }
 *     }
 */
public class CoinChange {

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        change(coins,coins.length - 1,0,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void change(int[] coins, int cIndex, int count, int amount) {
        if (amount == 0){
            ans = Math.min(ans,count);
            return;
        }
        if (cIndex < 0){
            return;
        }
        for (int k = amount / coins[cIndex]; k >= 0 && k + count < ans; k--){
            change(coins,cIndex - 1,k + count,amount - (coins[cIndex] * k));
        }
    }

}