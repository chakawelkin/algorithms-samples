package com.chaka.algorithms.binary_search;

/**
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">搜索二维矩阵</a>
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        while (left <= right){
            int pivotIdx = left + (right - left) / 2;
            int pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement){
                return true;
            }else {
                if (target < pivotElement){
                    right = pivotIdx - 1;
                }else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }

}
