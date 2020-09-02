package com.chaka.algorithms.sort.sorting;

/**
 * 插入排序
 * 1、从第2个元素拿出来开始在这个数据之前从后向前插入，当小于
 */
public class InsertSort {

    public int[] sort(int[] arr){
        int len = arr.length;
        int preIdx,curr;
        for (int i = 1; i < len; i++) {
            preIdx = i - 1;
            curr = arr[i];
            while (preIdx >=0 && arr[preIdx] > curr){
                arr[preIdx + 1] = arr[preIdx];
                preIdx--;
            }
            arr[preIdx + 1] = curr;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        for (int i : sort.sort(new int[]{1, 2, 4, 3, 23, 5, 7})) {
            System.out.println(i);
        }
    }

}
