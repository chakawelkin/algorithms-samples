package com.chaka.algorithms.hash;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/group-anagrams/">字母异位词分组</a>
 *  1、排序后相同的放在一起 (hash)
 *  {@code
 *  public List<List<String>> groupAnagrams(String[] strs) {
 *         Map<String,List<String>> map = new HashMap<>();
 *         for (int i = 0; i < strs.length; i++) {
 *             char[] chars = strs[i].toCharArray();
 *             Arrays.sort(chars);
 *             String value = String.valueOf(chars);
 *             List<String> list;
 *             if ((list = map.get(value)) == null){
 *                 map.put(value,list = new ArrayList<>());
 *             }
 *             list.add(strs[i]);
 *         }
 *         return new ArrayList<>(map.values());
 *     }
 *  }
 *  2、不使用排序的方式
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] key = new char[26];
            for (char aChar : strs[i].toCharArray()) {
                key[aChar - 'a']++;
            }
            List<String> list;
            if ((list = map.get(String.valueOf(key))) == null){
                map.put(String.valueOf(key),list = new ArrayList<>());
            }
            list.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}