package com.chaka.algorithms.divide_conquer;

/**
 * <a href="https://leetcode-cn.com/problems/powx-n/">Pow(x, n)</a>
 *  1、分治 需要注意大小边界
 */
public class PowxN {

    public double myPow(double x, int n) {
        if (n < 0){
            n = Math.abs(n);
            x = 1 / x;
        }
        return rePow(x,n);
    }

    private double rePow(double x, long n){
        if (n == 0){
            return 1;
        }
        return n % 2 == 0 ? rePow(x * x, (n / 2)) : x * rePow(x * x, (n / 2));
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MIN_VALUE);
        PowxN powxN = new PowxN();
        System.out.println(powxN.myPow(2,Integer.MIN_VALUE));
    }

}