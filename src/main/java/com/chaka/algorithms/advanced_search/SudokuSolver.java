package com.chaka.algorithms.advanced_search;

/**
 * <a href='https://leetcode-cn.com/problems/sudoku-solver/#/description'>解数独</a>
 */
public class SudokuSolver {

    boolean sudokuSolve;

    char[][] board;

    int[][] row = new int[9][10];
    int[][] col = new int[9][10];
    int[][] box = new int[9][10];

    private void placeNum(int i, int j, int val){
        row[i][val]++;
        col[j][val]++;
        int idx = i / 3 + (j / 3) * 3;
        box[idx][val]++;
        board[i][j] = (char)(val + '0');
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //进行标记
                if (board[i][j] != '.'){
                    placeNum(i,j,Character.getNumericValue(board[i][j]));
                }
            }
        }
        backtrack(0,0);
    }

    /**
     * 回溯
     * @param i
     * @param j
     */
    public void backtrack(int i,int j){
        if (board[i][j] == '.'){
            for (int k = 1; k < 10; k++) {
                if(couldPlace(k,i,j)){
                    placeNum(i,j,k);
                    placeNextNum(i,j);
                    if (!sudokuSolve){
                        removeNum(k,i,j);
                    }
                }
            }
        }else {
            placeNextNum(i, j);
        }
    }

    private void removeNum(int val, int i, int j) {
        row[i][val]--;
        col[j][val]--;
        int idx = i / 3 + (j / 3) * 3;
        box[idx][val]--;
        board[i][j] = '.';
    }

    private void placeNextNum(int i, int j){
        if (i == 8 && j == 8){
            sudokuSolve = true;
        }else {
            if (i == 8){
                backtrack(0,j + 1);
            }else {
                backtrack(i + 1,j);
            }
        }
    }

    private boolean couldPlace(int val,int i,int j){
        int idx = i / 3 + (j / 3) * 3;
        return row[i][val] == 0 && col[j][val] == 0 && box[idx][val] == 0;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solver.solveSudoku(board);
        System.out.println(board);
    }

}