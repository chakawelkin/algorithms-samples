package com.chaka.algorithms.dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-product-subarray/">乘积最大子数组</a>
 *
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num,num);
            imin = Math.min(imin * num,num);
            max = Math.max(imax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray productSubarray = new MaximumProductSubarray();
        System.out.println(productSubarray.maxProduct(new int[]{-2,0,-1}));
    }

}
