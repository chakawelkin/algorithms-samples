package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/valid-anagram/">有效的字母异位词</a>
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for (int i = 0;i < hash.length;i++){
            if (hash[i] != 0){
                return false;
            }
        }
        return true;
    }

}
