package com.chaka.algorithms.bit_operation;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-1-bits/">位1的个数</a>
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int bit = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            //与运算
            if ((mask & n) != 0){
                bit++;
            }
            mask = mask << 1;
        }
        return bit;
    }

    public static void main(String[] args) {
        NumberOf1Bits sol = new NumberOf1Bits();
        System.out.println(sol.hammingWeight(11));
    }

}