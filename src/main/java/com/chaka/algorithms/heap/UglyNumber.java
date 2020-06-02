package com.chaka.algorithms.heap;

/**
 * 丑数
 *  1、堆
 *  2、动态规划
 */
public class UglyNumber {

    //这么做超时了
    public int nthUglyNumber(int n) {
        int i = 1;
        int count = 0;
        int res = 1;
        while (count < n){
            if (isUgly(i++)){
                count++;
                res = i - 1;
            }
        }
        return res;
    }

    private boolean isUgly(int num){
        while(num % 2 == 0)
            num /= 2;
        while(num % 3 == 0)
            num /= 3;
        while(num % 5 == 0)
            num /= 5;
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber lcof = new UglyNumber();
        System.out.println(lcof.nthUglyNumber(11));
    }

}