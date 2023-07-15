// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:

// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:

// Input: n = 1
// Output: [["Q"]]

import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {

        // Create the chessboard as a 2D character array
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        // List to store all valid configurations
        List<List<String>> ans = new ArrayList<>();

        // Call the queen placement function
        queen(board, 0, ans);

        return ans;
    }

    static void queen(char[][] board, int row, List<List<String>> list) {

        // If all queens are placed, add the current configuration to the list
        if (row == board.length) {
            list.add(construct(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                queen(board, row + 1, list); // Recursively place queens in the next row
                board[row][col] = '.'; // Remove the queen (backtrack)
            }
        }
    }

    static List<String> construct(char[][] board) {

        // Convert the 2D character array to a list of strings
        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }

    static boolean isSafe(char[][] board, int row, int col) {

        // Check if placing a queen at the current position is safe

        // Check the vertical column for any queen
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the left diagonal for any queen
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        // Check the right diagonal for any queen
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true; // No conflicts, it's safe to place a queen
    }
}
