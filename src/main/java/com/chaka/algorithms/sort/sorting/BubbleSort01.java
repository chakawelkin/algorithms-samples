package com.chaka.algorithms.sort.sorting;

public class BubbleSort01 {

    public static int[] bubbleSort(int[] arr) {
        for(int i = 1;i < arr.length;i++){
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        for (int i : BubbleSort01.bubbleSort(new int[]{1, 2, 7, 3, 5, 2})) {
            System.out.println(i);
        }
    }

}
