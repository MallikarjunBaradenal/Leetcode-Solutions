class Solution {
    public boolean exist(char[][] board, String word) {       // Search for the word in the grid
        int rows = board.length;                              // Number of rows
        int cols = board[0].length;                           // Number of columns

        for (int r = 0; r < rows; r++) {                      // Try every cell as a starting point
            for (int c = 0; c < cols; c++) {                  // Check every column
                if (dfs(board, word, r, c, 0)) {              // Start DFS from this cell
                    return true;                              // Word was successfully found
                }
            }
        }

        return false;                                         // No valid path exists
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) { // Explore one path
        if (index == word.length()) {                         // Entire word has been matched
            return true;                                      // Successful search
        }

        if (r < 0 || r >= board.length ||                   // Row is outside the grid
            c < 0 || c >= board[0].length ||                 // Column is outside the grid
            board[r][c] != word.charAt(index)) {             // Current character does not match
            return false;                                     // This path cannot work
        }

        char temp = board[r][c];                              // Save the current character
        board[r][c] = '#';                                    // Mark cell as visited

        boolean found = dfs(board, word, r + 1, c, index + 1) || // Move down
                        dfs(board, word, r - 1, c, index + 1) || // Move up
                        dfs(board, word, r, c + 1, index + 1) || // Move right
                        dfs(board, word, r, c - 1, index + 1);   // Move left

        board[r][c] = temp;                                   // Restore cell for other paths
        return found;                                         // Return whether any direction worked
    }
}