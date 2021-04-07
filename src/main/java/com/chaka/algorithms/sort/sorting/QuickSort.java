package com.chaka.algorithms.sort.sorting;

/**
 * 快速排序，主要是利用分治的思想来完成处理的
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.sort(new int[]{2,4,3,9,7,1});
    }

    public void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
        for(int num:nums){
            System.out.println(num);
        }
    }

    private void quickSort(int[] nums, int start, int end){
        if (start > end){
            return;
        }
        int middle = partition(nums,start,end);
        quickSort(nums,start,middle - 1);
        quickSort(nums,middle + 1,end);
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right){
            //找到第一个大于pivot的
            while (left < right && nums[left] <= pivot){
                left++;
            }
            //找到第一个小于pivot的
            while (left < right && nums[right] >= pivot){
                right--;
            }
            if (left < right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        if (left == right && nums[right] > pivot){
            right--;
        }
        //基数和中间数交换
        swap(nums,start,right);
        return right;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
