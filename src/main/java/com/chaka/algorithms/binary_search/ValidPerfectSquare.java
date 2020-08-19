package com.chaka.algorithms.binary_search;

/**
 * <a href="https://leetcode-cn.com/problems/valid-perfect-square/">有效的完全平方数</a>
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num + 1;
        while (left <= right){
            long mid = left + (right - left + 1) / 2;
            long square = mid * mid;
            if (square == num){
                return true;
            }
            if (square > num){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

}
