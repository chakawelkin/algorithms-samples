package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">字符串转换整数 (atoi)</a>
 */
public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        int start = 0;
        char a;
        int symbol = 1;
        while (start < str.length() && ((a = str.charAt(start)) == ' ' || a == '-' || a == '+')){
            start++;
            if (a != ' '){
                symbol = a == '-' ? -1 : 1;
                break;
            }
        }
        long result = 0L;
        int c;
        while (start < str.length() && Character.isDigit(c = str.charAt(start++))){
            result = (result * 10) + c - '0';
            if (result > Integer.MAX_VALUE){
                break;
            }
        }
        result = result * symbol;
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else {
            return (int)result;
        }
    }

}