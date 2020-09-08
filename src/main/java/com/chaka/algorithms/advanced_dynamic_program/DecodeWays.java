package com.chaka.algorithms.advanced_dynamic_program;

/**
 * <a href="https://leetcode-cn.com/problems/decode-ways/">解码方法</a>
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] mem = new int[length + 1];
        mem[0] = 1;
        mem[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= length; i++) {
            int first = Integer.parseInt(s.substring(i-1,i));
            int second = Integer.parseInt(s.substring(i-2,i));
            if (first >= 1 && first <=9){
                mem[i] += mem[i-1];
            }
            if (second >= 10 && second <= 26){
                mem[i] += mem[i-2];
            }
        }
        return mem[length];
    }

    public static void main(String[] args) {
        DecodeWays solv = new DecodeWays();
        System.out.println(solv.numDecodings("15"));
    }

}