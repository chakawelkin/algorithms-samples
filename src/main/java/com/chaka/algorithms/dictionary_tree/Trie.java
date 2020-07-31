package com.chaka.algorithms.dictionary_tree;

/**
 * <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">实现 Trie (前缀树)</a>
 *  1、实现trie树
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
           if (node.next[c - 'a'] == null){
               node.next[c - 'a'] = new TrieNode();
           }
           node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if ((node = node.next[c - 'a']) == null){
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if ((node = node.next[c - 'a']) == null){
                return false;
            }
        }
        return true;
    }

    /**
     *
     */
    static class TrieNode{

        public boolean isEnd;

        public TrieNode[] next;

        public TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
        }

    }

}