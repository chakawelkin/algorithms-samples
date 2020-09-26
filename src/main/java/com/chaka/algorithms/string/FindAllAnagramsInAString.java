package com.chaka.algorithms.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/">找到字符串中所有字母异位词</a>
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
            return ans;
        }
        int left = 0, right = p.length();
        while (right <= s.length()){
            if (isAnagram(s.substring(left,right),p)){
                ans.add(left);
            }
            left++;
            right++;
        }
        return ans;
    }

    private boolean isAnagram(String s,String t){
        char[] chars = new char[26];
        for (int j = 0; j < t.length(); j++) {
            chars[s.charAt(j) - 'a']++;
            chars[t.charAt(j) - 'a']--;
        }
        for (char achar : chars){
            if (achar != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString solve = new FindAllAnagramsInAString();
        List<Integer> anagrams = solve.findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }

}
