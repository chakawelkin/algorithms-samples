package com.chaka.algorithms.divide_conquer;

/**
 * <a href="https://leetcode-cn.com/problems/majority-element/description/">多数元素</a>
 *  1、排序后，直接拿到对应的值
 *  2、分治
 *  {@code
 *      public int majorityElementDivide(int[] nums,int lo,int hi){
 *         if (lo == hi){
 *             return nums[lo];
 *         }
 *
 *         int mid = (hi - lo)/2 + lo;
 *
 *         int left = majorityElementDivide(nums, lo, mid);
 *         int right = majorityElementDivide(nums, mid + 1, hi);
 *
 *         if (left == right){
 *             return left;
 *         }
 *
 *         int leftCount = count(nums, left, lo, hi);
 *         int rightCount = count(nums, right, lo, hi);
 *         return leftCount > rightCount ? left : right;
 *     }
 *  }
 *  3、Boyer-Moore 投票算法  （摩尔投票方法）
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = nums[0],count = 1;
        for (int i = 1; i < nums.length; i++) {
            count += candidate == nums[i] ? 1 : -1;
            if (count == 0){
                candidate = nums[i];
                count++;
            }
        }
        return candidate;
    }

}