package com.chaka.algorithms.list;

/**
 * 合并两个有序数组
 * 1、双指针
 * 2、合并后排序
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        while (m > 0 && n > 0){
            if (nums1[m - 1] > nums2[n - 1]){
                nums1[tail] = nums1[m -1];
                m--;
            }else {
                nums1[tail] = nums2[n -1];
                //nums2遍历完就结束
                n--;
            }
            tail--;
        }
        if (m < 1){
            System.arraycopy(nums2,0,nums1,0,n);
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{0},0,new int[]{1},1);
    }

}
