class Solution {
    public void solveSudoku(char[][] board) {
        solve(board); // Start solving
    }

    // Try to solve the board recursively
    private boolean solve(char[][] board) {

        // Traverse every cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Empty cell found
                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        // Check whether placing is valid
                        if (isValid(board, row, col, num)) {

                            board[row][col] = num; // Place digit

                            // If remaining board solved
                            if (solve(board))
                                return true;

                            board[row][col] = '.'; // Backtrack
                        }
                    }

                    return false; // No digit fits
                }
            }
        }

        return true; // Entire board solved
    }

    // Check row, column and box
    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == num)
                return false;

            if (board[i][col] == num)
                return false;

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == num)
                return false;
        }

        return true;
    }
}