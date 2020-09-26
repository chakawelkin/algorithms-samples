package com.chaka.algorithms.string;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int i = 0; int j = s.length() - 1;
        for (;i < j;){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                boolean flag1 = true,flag2 = true;
                //删左边
                int left = i + 1,right = j;
                for (;left < right;){
                    if (s.charAt(left++) != s.charAt(right--)){
                        flag1 = false;
                        break;
                    }
                }
                //删右边
                left = i;right = j - 1;
                for (;left < right;){
                    if (s.charAt(left++) != s.charAt(right--)){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII solve = new ValidPalindromeII();
        System.out.println(solve.validPalindrome("abc"));
    }

}
