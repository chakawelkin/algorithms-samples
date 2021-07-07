package com.chaka.algorithms.sort.sorting;

/**
 * 希尔排序
 */
public class ShellSort {

    public int[] sort(int[] arr){
        int len = arr.length;
        // eg : gap == 5/2/1
        for (int gap = len /2; gap > 0; gap = gap / 2){
            //5
            for (int i = gap; i < len;i++){
                int j = i;//5
                int curr = arr[i];
                while (j - gap >= 0 && curr < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = curr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        for (int i : sort.sort(new int[]{6, 2, 1, 3, 5, 4})) {
            System.out.println(i);
        }
    }
}
