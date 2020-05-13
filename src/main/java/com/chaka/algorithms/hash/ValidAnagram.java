package com.chaka.algorithms.hash;

/**
 * 有效的字母异位词
 *  1、排序
 *  {@code
 *  public boolean isAnagram(String s, String t) {
 *         if (s.length() != t.length()){
 *             return false;
 *         }
 *         char[] chars1 = s.toCharArray();
 *         char[] chars2 = t.toCharArray();
 *         Arrays.sort(chars1);
 *         Arrays.sort(chars2);
 *         return Arrays.equals(chars1,chars2);
 *     }
 *  }
 *  2、哈希表
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] arrs = new int[26];
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            arrs[chars1[i] - 'a']++;
            arrs[chars2[i] - 'a']--;
        }

        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram","nagaram"));
    }

}