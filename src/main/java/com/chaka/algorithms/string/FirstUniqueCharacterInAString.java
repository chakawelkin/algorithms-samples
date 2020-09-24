package com.chaka.algorithms.string;

/**
 * <a href="https://leetcode-cn.com/problems/first-unique-character-in-a-string/">字符串中的第一个唯一字符</a>
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if(s == null || s.equals("")){
            return -1;
        }
        if(s.length() == 1){
            return 0;
        }
        int[] tag = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //之前被标记为重复的
            if (tag[i] == 1){
                continue;
            }
            //当前相同的个数
            int cnt = 0;
            //当前值
            char c = chars[i];
            int start = i;
            while (start < chars.length){
                if (c == chars[start] && start != i){
                    tag[start] = 1;
                    cnt++;
                }
                start++;
            }
            if (cnt == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString solve = new FirstUniqueCharacterInAString();
        System.out.println(solve.firstUniqChar("aadadaad"));
    }

}