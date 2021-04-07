package com.chaka.algorithms.sort.sorting;

/**
 * @author chaka.hu
 * @date 2021/4/7 11:31 上午
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort.sort(new int[]{4,6,8,5,9});
    }

    public static void sort(int[] nums){
        //构建大顶堆
        buildMaxHeap(nums);
        //交换元素,依次将大顶推的根节点拿出来放在数组最后
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums,0,i);
            //每次调整堆顶元素
            maxHeapify(nums,0,i);
        }
        for(int num:nums){
            System.out.println(num);
        }
    }

    //构建大顶堆
    private static void buildMaxHeap(int[] nums){
        //从最后一个非叶子节点开始
        for (int i = nums.length/2 - 1; i >= 0 ; i--) {
            maxHeapify(nums,i,nums.length);
        }
    }

    private static void maxHeapify(int[] nums,int i,int heapSize){
        //左子节点
        int left = 2 * i + 1;
        //右子节点
        int right = left + 1;
        //默认根节点是最大的数
        int largestIdx = i;
        //左子节点大于父节点
        if (left < heapSize && nums[left] > nums[largestIdx]){
            largestIdx = left;
        }
        if(right < heapSize && nums[right] > nums[largestIdx]){
            largestIdx = right;
        }
        if(largestIdx != i){
            swap(nums,largestIdx,i);
            maxHeapify(nums,largestIdx,heapSize);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}