package com.chaka.algorithms.dynamic_program;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/coin-change/">零钱兑换</a>
 *  1、贪心 + dfs
 *  2、动态规划  -- 自顶向下和自底向上
 *     -- dp数组的迭代解法，使用dp table来消除重叠子问题
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0){
                    continue;
                }
                //递归，选择硬币数最少的那种
                dp[i] = Math.min(dp[i],1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
