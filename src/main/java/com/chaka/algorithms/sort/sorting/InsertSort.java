package com.chaka.algorithms.sort.sorting;

/**
 * 插入排序
 * 1、从第2个元素拿出来开始在这个数据之前从后向前插入，当小于
 */
public class InsertSort {

    public int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            //不断将比curr大的数字向后挪
            while (j >= 0 && curr < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
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
