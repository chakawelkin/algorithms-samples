package com.chaka.algorithms.binary_search;

/**
 * <a href="https://leetcode-cn.com/problems/sqrtx/">x 的平方根</a>
 *  1、二分法 :
 *  {@code public int mySqrt(int x) {
 *         long left = 0;
 *         long right = (x / 2) + 1; // 照顾到右边界
 *         while (left < right) {
 *             long mid = left + (right - left + 1)/2;
 *             long square = mid * mid;
 *             if (square > x){
 *                 right = mid - 1;
 *             }else {
 *                 left = mid;
 *             }
 *         }
 *         return (int)left;
 *  }}
 *
 */
public class Sqrtx {

    public int mySqrt(int x) {
        long a = x;
        while (a * a > x){
            a = (a + x / a) / 2;
        }
        return (int)a;
    }

}
