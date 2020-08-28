package com.chaka.algorithms.bit_operation;

/**
 * <a href="https://leetcode-cn.com/problems/power-of-two/">2的幂</a>
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1){
                count++;
            }
            n = n >> 1;
            if (count > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(1));
    }

}
