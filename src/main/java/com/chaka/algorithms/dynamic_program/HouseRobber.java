package com.chaka.algorithms.dynamic_program;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/house-robber/">打家劫舍</a>
 *
 * {@code
 * public int rob(int[] nums) {
 *         if (nums.length == 0){
 *             return 0;
 *         }
 *         int[][] dp = new int[nums.length][2];
 *         dp[0][0] = 0;
 *         dp[0][1] = nums[0];
 *         for (int i = 1; i < dp.length; i++) {
 *             //每次偷与不偷只需要确认之前能不能偷就可以
 *             dp[i][0] = Math.max(dp[i - 1][1],dp[i - 1][0]);
 *             dp[i][1] = dp[i -1][0] + nums[i];
 *         }
 *
 *         return Math.max(dp[dp.length - 1][0],dp[dp.length - 1][1]);
 *      }}

 *
 */
public class HouseRobber {

    //二维状态数组记录
    public int rob(int[] nums) {
        int n = nums.length;
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp = 0;
        for (int i = 2; i < n + 2; i++) {
            //1、这一间不偷那么当前偷到的最大值为上一间
            //2、这一间偷，那么为当间的金额加上上上间的金额
            dp = Math.max(dp_i_1,nums[i - 2] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp;
        }
        return dp;
    }



    /**
     * 起始金额肯定为0
     * 1、不抢，去下家
     * 2、抢，去下下家
     */

    /*public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dp(nums, dp,0);
    }

    public int dp(int[] nums, int[] dp, int start){
        if (start >= nums.length){
            return 0;
        }
        if (dp[start] == -1){
            dp[start] = Math.max(dp(nums, dp, start + 1), nums[start] + dp(nums, dp, start + 2));
        }
        return dp[start];
    }*/

}