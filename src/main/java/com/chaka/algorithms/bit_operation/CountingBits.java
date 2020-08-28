package com.chaka.algorithms.bit_operation;

/**
 * <a href="https://leetcode-cn.com/problems/counting-bits/description/">比特位计数</a>
 *  1、计算每个数中1的个数
 *  2、动态规划 + 最高有效位
 *  3、动态规划 + 最低有效位
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num){
            while (i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;
            b = b << 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits sol = new CountingBits();
        for (int i : sol.countBits(5)) {
            System.out.println(i);
        }
    }

}