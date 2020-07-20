package com.chaka.algorithms.dynamic_program;

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
 *
 */
public class HouseRobber {

    //二维状态数组记录
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int ans = dp[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i -1],dp[i - 2] + nums[i]);
            ans = Math.max(dp[i],ans);
        }
        return ans;
     }

}