package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/house-robber-ii/description/">打家劫舍二</a>
 * 1、第1间 -> 倒数第2间
 * 2、第2间 -> 最后1间
 */
public class HouseRobberTwo {

    public int rob(int[] nums) {
        return Math.max(robRange(nums,0,nums.length - 1),
                        robRange(nums,1,nums.length));
    }

    public int robRange(int[] nums,int start,int end){
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp = 0;
        for (int i = start + 2; i < end + 2; i++) {
            //1、这一间不偷那么当前偷到的最大值为上一间
            //2、这一间偷，那么为当间的金额加上上上间的金额
            dp = Math.max(dp_i_1,nums[i - 2] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp;
        }
        return dp;
    }

}
