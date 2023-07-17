// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

// Example 1:


// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]

package Day75;

class Solution {
    public void solveSudoku(char[][] board) {
        // Start solving sudoku from the first cell
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // Base case: If row is equal to board length, entire board has been filled
        if (row == board.length) {
            return true; // Sudoku solved successfully
        }
        
        // Move to the next row when the current row is fully filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0); // Move to the next row, starting from the first column
        }
        
        // Skip cells that are already filled
        if (board[row][col] != '.') {
            return solve(board, row, col + 1); // Move to the next column
        }
        
        // Try different numbers in the current cell
        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num; // Fill the current cell with a valid number
                
                // Move to the next cell
                if (solve(board, row, col + 1)) {
                    return true; // Sudoku solved successfully
                }
                
                // Backtrack to the previous state if a solution is not found
                board[row][col] = '.'; // Undo the current placement and try the next number
            }
        }
        
        // No valid solution found
        return false;
    }

    private boolean isValidPlacement(char[][] board, int row, int col, char num) {
        // Check if num is already in the same row, column, or 3x3 subgrid
        
        for (int i = 0; i < board.length; i++) {
            // Check row
            if (board[i][col] == num) {
                return false; // Number already exists in the current column
            }

            // Check column
            if (board[row][i] == num) {
                return false; // Number already exists in the current row
            }
 
            // Check 3x3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3; // Calculate row index of the subgrid
            int subgridCol = 3 * (col / 3) + i % 3; // Calculate column index of the subgrid
 
            if (board[subgridRow][subgridCol] == num) {
                return false; // Number already exists in the current subgrid
            }
        }

        // Placement is valid
        return true;
    }
}
