package com.chaka.algorithms.dfs_bfs;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-islands/">岛屿数量</a>
 * 1、DFS + BFS
 * 2、并查集
 */
public class NumberOfIslands {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;
    private int count;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return count;
        }
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j);
                count++;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= m ||j >= n){
            return;
        }
        if (grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            dfs(grid,i + dir[0],j + dir[1]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0'},
                {'1','1','0'},
                {'0','0','1'},
        };
        NumberOfIslands sol = new NumberOfIslands();
        System.out.println(sol.numIslands(grid));
    }

}