package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/house-robber-ii/description/">打家劫舍二</a>
 * 1、第1间 -> 倒数第2间
 * 2、第2间 -> 最后1间
 */
public class HouseRobberTwo {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(roRange(nums,0,nums.length - 1),
                roRange(nums,1,nums.length));
    }

    private int roRange(int[] nums,int start,int end){
        int[][] dp = new int[end - start][2];
        dp[0][0] = 0;
        dp[0][1] = nums[start];
        for (int i = 1; i < end -start; i++) {
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + nums[i + start];
        }
        return Math.max(dp[end -start-1][1],dp[end -start-1][0]);
    }

    public static void main(String[] args) {
        HouseRobberTwo solve = new HouseRobberTwo();
        solve.rob(new int[]{2,3,2});
    }
}
