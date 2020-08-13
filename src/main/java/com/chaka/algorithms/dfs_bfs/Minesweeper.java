package com.chaka.algorithms.dfs_bfs;

/**
 * <a href="https://leetcode-cn.com/problems/minesweeper/description/">扫雷游戏</a>
 * 1、DFS
 * 2、BFS
 */
public class Minesweeper {

    /**
     * 8向图
     */
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (board[row][col] == 'M' || board[row][col] == 'X'){
            board[row][col] = 'X';
            return board;
        }
        int m = board.length, n =board[0].length;
        int num = 0;
        //判断8方位是不是会有地雷
        for (int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newCol >=0 && newRow < m && newCol < n
                && board[newRow][newCol] == 'M'){
                num++;
            }
        }

        //挖出地雷了
        if (num > 0){
            board[row][col] = (char)(num + '0');
            return board;
        }

        board[row][col] = 'B';

        for (int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newCol >=0 && newRow < m && newCol < n
                    && board[newRow][newCol] == 'E'){
                updateBoard(board,new int[]{newRow,newCol});
            }
        }

        return board;
    }

}