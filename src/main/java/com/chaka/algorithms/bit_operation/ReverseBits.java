package com.chaka.algorithms.bit_operation;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-bits/">颠倒二进制位</a>
 */
public class ReverseBits {

    public int reverseBits(int n) {
        if(n == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((n & 1) == 1){
                result++;
            }
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits reverse = new ReverseBits();
        System.out.println(reverse.reverseBits(5));
    }

}