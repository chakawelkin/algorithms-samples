package com.chaka.algorithms.advanced_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/">二进制矩阵中的最短路径</a>
 * BFS
 */
public class ShortestPathInBinaryMatrix {

    private int[][] dictionaries = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row-1][col-1] == 1){
            return -1;
        }
        Queue<int[]> pos = new LinkedList<>();
        grid[0][0] = 1;
        pos.add(new int[]{0,0});
        while (!pos.isEmpty()){
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]];
            for(int[] dict : dictionaries){
                int newX = xy[0] + dict[0];
                int newY = xy[1] + dict[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 0){
                    grid[newX][newY] = preLength + 1;
                    pos.add(new int[]{newX,newY});
                }
            }
        }
        return grid[row-1][col-1] == 0 ? -1 : grid[row-1][col-1];
    }


}