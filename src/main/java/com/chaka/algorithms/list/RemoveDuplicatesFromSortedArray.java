package com.chaka.algorithms.list;

/**
 * 删除排序数组中的重复项
 *  双指针，快慢指针
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        //返回数量
        return i + 1;
    }

}