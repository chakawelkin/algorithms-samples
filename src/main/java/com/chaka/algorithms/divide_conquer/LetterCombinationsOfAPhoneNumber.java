package com.chaka.algorithms.divide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">电话号码的字母组合</a>
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 1、回溯
 * 2、队列
 */
public class LetterCombinationsOfAPhoneNumber {

    private String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result;
        }
        divide(digits,"",0);
        return result;
    }

    public void divide(String digits,String letter,int index){
        if (index == digits.length()){
            result.add(letter);
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0';
        char[] chars = letter_map[pos].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            divide(digits,letter + chars[i],index + 1);
        }
    }

    /**
     * Map<String, String> map = new HashMap<>();
    *   map.put("2","abc");
    *   map.put("3","def");
    *   map.put("4","ghi");
    *   map.put("5","jkl");
    *   map.put("6","mno");
    *   map.put("7","rst");
    *   map.put("8","tuv");
    *   map.put("9","wxyz");
     */



}
