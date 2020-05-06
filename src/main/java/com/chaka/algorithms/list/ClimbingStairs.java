package com.chaka.algorithms.list;

/**
 * 爬楼梯
 *  1、斐波拉契数列
 *  2、动态规划
 */
public class ClimbingStairs {

    //todo 空间复杂度优化
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i -1] + dp[i -2];
        }
        return dp[n];
    }


}