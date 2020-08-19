package com.chaka.algorithms.binary_search;

/**
 * <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">搜索旋转排序数组</a>
 * 1、先找到旋转数组最小值的索引，然后再进行二分查找
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (target >= nums[0]){
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else {
                if (nums[mid] >= nums[0]){
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
