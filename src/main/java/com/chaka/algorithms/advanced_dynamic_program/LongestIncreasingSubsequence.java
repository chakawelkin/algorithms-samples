package com.chaka.algorithms.advanced_dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">最长上升子序列</a>
 *  动态规划 + 二分查找
 *  优先追加较小的同时，保持之前最长的长度不能变
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int n = nums.length;
        int res = 0;
        for (int idx = 0;idx < n;idx++){
            int curr = nums[idx];
            int i = 0, j = res;
            while (i < j){
                int mid = i + (j - i) / 2;
                if(tails[mid] < curr){
                    i = mid + 1;
                }else {
                    j = mid;
                }
            }
            tails[i] = curr;
            if (res == j){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence solve = new LongestIncreasingSubsequence();
        System.out.println(solve.lengthOfLIS(nums));
    }

}

/*
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            //当前值
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}*/
