package com.chaka.algorithms.advanced_search;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/sliding-puzzle/">滑动谜题</a>
 */
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String start = "";
        String target = "123450";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        int[][] neighbor = new int[][]{
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {1,3,5},
                {2,4}
        };

        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (target.equals(curr)){
                    return step;
                }
                int idx = curr.indexOf('0');
                for (int dir : neighbor[idx]){
                    String next = swap(curr, idx, dir);
                    if (visited.contains(next)){
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String curr ,int i,int j){
        StringBuilder str = new StringBuilder(curr);
        str.setCharAt(i,curr.charAt(j));
        str.setCharAt(j,curr.charAt(i));
        return str.toString();
    }

    public static void main(String[] args) {
        SlidingPuzzle solve = new SlidingPuzzle();
        int[][] board = new int[][]{
                {1,2,3},
                {4,0,5}
        };
        System.out.println(solve.slidingPuzzle(board));
    }

}