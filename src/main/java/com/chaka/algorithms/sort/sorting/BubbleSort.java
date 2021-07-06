package com.chaka.algorithms.sort.sorting;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arrs = {1, 5, 3, 2, 4};
        BubbleSort.bubbleSort(arrs);
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }


}
