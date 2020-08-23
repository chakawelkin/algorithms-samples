package com.chaka.algorithms.advanced_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/word-ladder/">单词接龙</a>
 * 1、双向BFS
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);

        Set<String> leftSet = new HashSet<>();
        leftSet.add(beginWord);
        Set<String> rightSet = new HashSet<>();
        rightSet.add(endWord);

        Set<String> visited = new HashSet<>();
        int depth = 1;
        while (!leftSet.isEmpty() && !rightSet.isEmpty()){
            if (rightSet.size() < leftSet.size()){
                Set<String> temp = leftSet;
                leftSet = rightSet;
                rightSet = temp;
            }

            Set<String> newSet = new HashSet<>();
            for (String left : leftSet) {
                for (int idx = 0; idx < left.length(); idx++) {
                    StringBuilder word = new StringBuilder(left);
                    for(int i = 'a'; i <= 'z'; i++){
                        word.setCharAt(idx,(char)i);
                        String newWord = word.toString();
                        if (rightSet.contains(newWord)){
                            return depth + 1;
                        }
                        if (dict.contains(newWord) && !visited.contains(newWord)){
                            newSet.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            depth++;
            leftSet = newSet;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        int i = wordLadder.ladderLength("hit",
                "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }

}