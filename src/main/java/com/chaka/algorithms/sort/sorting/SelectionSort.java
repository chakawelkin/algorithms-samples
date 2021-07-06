package com.chaka.algorithms.sort.sorting;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int minIdx;
        for (int i = 0; i < arr.length; i++) {
            minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{1,6,2,4,6,2};
        SelectionSort.selectionSort(arrs);
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }

}
