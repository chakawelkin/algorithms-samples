package com.chaka.algorithms.dictionary_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href='https://leetcode-cn.com/problems/word-search-ii/'>单词搜索 II</a>
 */
public class WordSearchTwo {

    private final Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        //构建trie树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null){
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }

        int max_line = board.length;
        int max_col = board[0].length;
        for (int i = 0; i < max_line; i++) {
            for (int j = 0; j < max_col; j++) {
                visit(board,i,j,max_line,max_col,"",root);
            }
        }
        return new ArrayList<>(res);
    }

    public void visit(char[][] board, int i, int j, int max_line, int max_col, String val, TrieNode curr){
        if(i < 0 || i >= max_line || j < 0 || j>= max_col || board[i][j] == '#'){
            return;
        }
        char c = board[i][j];
        //将单词进行匹配
        curr = curr.next[c - 'a'];
        val = val + c;
        //未匹配到,直接返回上一级
        if (curr == null){
            return;
        }

        //标记该节点已经遍历
        board[i][j] = '#';
        if (curr.isEnd){
            res.add(val);//找到后不能终止
        }
        visit(board,i + 1,j,max_line,max_col,val,curr);
        visit(board,i - 1,j,max_line,max_col,val,curr);
        visit(board,i,j + 1,max_line,max_col,val,curr);
        visit(board,i,j - 1,max_line,max_col,val,curr);

        board[i][j] = c;
    }

    private static class TrieNode{

        public boolean isEnd;

        public TrieNode[] next;

        public TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
        }

    }

    public static void main(String[] args) {
        WordSearchTwo wordSearchTwo = new WordSearchTwo();
        List<String> words = wordSearchTwo.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"});
        System.out.println(words);
    }

}