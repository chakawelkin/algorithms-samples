package com.chaka.algorithms.dfs_bfs;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/word-ladder-ii/description/">单词接龙 II</a>
 */
public class WordLadderTwo {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return result;
        }
        Set<String> dict = new HashSet<>(wordList);
        Map<String,Integer> distance = new HashMap<>();
        Map<String,List<String>> nodeNeighbors = new HashMap<>();//节点邻居
        List<String> solution = new ArrayList<>();
        bfs(beginWord,endWord,dict,nodeNeighbors,distance);
        dfs(beginWord,endWord,solution,nodeNeighbors,distance);
        return result;
    }

    private void dfs(String curr, String endWord, List<String> solution, Map<String,List<String>> nodeNeighbors, Map<String,Integer> distance){
        solution.add(curr);
        if (endWord.equals(curr)){
            result.add(new ArrayList<>(solution));
        }else {
            for (String next : nodeNeighbors.get(curr)) {
                if (distance.get(next) == distance.get(curr) + 1){
                    dfs(next,endWord,solution,nodeNeighbors,distance);
                }
            }
        }
        solution.remove(curr);
    }

    private void bfs(String beginWord, String endWord,Set<String> dict,Map<String,List<String>> nodeNeighbors,Map<String,Integer> distance){
        distance.put(beginWord,0);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        boolean finded = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> neighbors = getNeighbors(word, dict);//获取该节点的邻居节点
                nodeNeighbors.put(word,neighbors);
                //过滤掉已经走过的邻居节点
                Integer currDistance = distance.get(word);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)){//代表节点没走过
                        distance.put(neighbor,currDistance + 1);
                        if (endWord.equals(neighbor)){
                            finded = true;
                        }else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (finded){
                    break;
                }
            }
        }
    }

    private List<String> getNeighbors(String node,Set<String> dict){
        List<String> list = new ArrayList<>();
        for (int idx = 0; idx < node.length(); idx++) {
            StringBuilder word = new StringBuilder(node);
            for (int c = 'a'; c <= 'z'; c++) {
                word.setCharAt(idx,(char)c);
                String newWord = word.toString();
                if (dict.contains(newWord)){
                    list.add(newWord);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        WordLadderTwo wordLadderTwo = new WordLadderTwo();
        List<List<String>> ladders = wordLadderTwo.findLadders("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladders);
    }

}
