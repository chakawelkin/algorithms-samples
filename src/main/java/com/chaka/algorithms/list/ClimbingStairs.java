package com.chaka.algorithms.list;

/**
 * 爬楼梯
 *  1、斐波拉契数列
 *  2、动态规划
 *  {@code
 *  public int climbStairs(int n) {
 *         int[] dp = new int[n + 1];
 *         dp[0] = 1;
 *         dp[1] = 1;
 *         for (int i = 2; i < n + 1; i++) {
 *             dp[i] = dp[i -1] + dp[i -2];
 *         }
 *         return dp[n];
 *     }}
 *  3、递归 （时间复杂度太高）
 *  {@code public int recursionClimb(int i, int n){
 *         if (i > n){
 *             return 0;
 *         }
 *         if (i == n){
 *             return 1;
 *         }
 *         return recursionClimb(i + 1,n) + recursionClimb(i + 2,n);
 *     }}
 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] memo =new int[n + 1];
        return recursionClimb(0,n,memo);
    }

    /**
     * 带有缓存的递归
     * @param i
     * @param n
     * @param memo
     * @return
     */
    public int recursionClimb(int i, int n, int[] memo){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }
        if (memo[i] > 0){
            return memo[i];
        }
        memo[i] = recursionClimb(i + 1,n, memo) + recursionClimb(i + 2,n, memo);
        return memo[i];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(5));
    }

}