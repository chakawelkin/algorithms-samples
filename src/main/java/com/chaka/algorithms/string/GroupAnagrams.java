package com.chaka.algorithms.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/group-anagrams/">字母异位词分组</a>
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] key = new char[26];
            for (int j = 0; j < str.length(); j++){
                key[str.charAt(j) - 'a']++;
            }
            List<String> list = ans.computeIfAbsent(new String(key), k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(ans.values());
    }

}
