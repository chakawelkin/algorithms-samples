package com.chaka.algorithms.dfs_bfs;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/word-ladder/description/">单词接龙</a>
 *  单向BFS
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder word = new StringBuilder(queue.poll());
                for (int idx = 0; idx < word.length(); idx++) {
                    char ch = word.charAt(idx);
                    for (int j = 'a'; j <= 'z'; j++) {
                        if (ch == j){
                            continue;
                        }
                        word.setCharAt(idx,(char)j);
                        String newWord = word.toString();
                        if (newWord.equals(endWord)){
                            return step + 1;
                        }
                        if (dict.contains(newWord)){
                            queue.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                    // 还原
                    word.setCharAt(idx,ch);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        int i = ladder.ladderLength("ymain", "oecij",
                Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"));
        System.out.println(i);
    }

}
