package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">最大子序和</a>
 * 1、动态规划
 * 2、贪心算法
 * 3、分治
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0){//当和大于0时，说明对结果是有增益效果的
                sum += nums[i];
            }else {//其次，没有增益效果，则直接赋值即可
                sum = nums[i];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
