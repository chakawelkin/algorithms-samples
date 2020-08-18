package com.chaka.algorithms.binary_search;

/**
 * <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/"寻找旋转排序数组中的最小值></a>
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

}