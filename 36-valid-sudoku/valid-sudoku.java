class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];   // Digits used in each row
        boolean[][] col = new boolean[9][9];   // Digits used in each column
        boolean[][] box = new boolean[9][9];   // Digits used in each 3x3 box

        for (int i = 0; i < 9; i++) {                  // Traverse rows
            for (int j = 0; j < 9; j++) {              // Traverse columns

                if (board[i][j] == '.') continue;      // Ignore empty cells

                int num = board[i][j] - '1';           // Convert '1'-'9' to 0-8
                int boxIndex = (i / 3) * 3 + (j / 3);  // Find box number

                if (row[i][num] || col[j][num] || box[boxIndex][num])
                    return false;                      // Duplicate found

                row[i][num] = true;                   // Mark in row
                col[j][num] = true;                   // Mark in column
                box[boxIndex][num] = true;            // Mark in box
            }
        }

        return true;                                  // Valid Sudoku
    }
}