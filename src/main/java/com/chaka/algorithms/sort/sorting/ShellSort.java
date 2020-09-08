package com.chaka.algorithms.sort.sorting;

/**
 * 希尔排序
 */
public class ShellSort {

    public int[] sort(int[] arr){
        int len = arr.length;
        // eg : gap == 5/2/1
        for (int gap = len /2; gap > 0; gap = gap / 2){
            for (int i = gap; i < len;i++){
                int j = i;
                int curr = arr[i];
                while (j - gap >= 0 && curr < arr[j - gap]){
                    arr[i] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = curr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        for (int i : sort.sort(new int[]{1, 2, 4, 3, 23, 5, 7})) {
            System.out.println(i);
        }
    }
}
