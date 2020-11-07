package com.chaka.algorithms.sort.sorting;

/**
 * 归并排序
 */

public class MergeSort {

    private void sort(int[] arr, int left, int right){
        if (left == right){
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr,left,mid);
        sort(arr,mid + 1,right);
        merge(arr,left,mid,right);
    }

    public void merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[right -left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            temp[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while (p2 <= right){
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{50,3,5,78,56,29,32,7,29,9};
        MergeSort sort = new MergeSort();
        sort.sort(arr,0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
