class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(); // store all valid boards

        char[][] board = new char[n][n]; // represent the chessboard

        for (char[] row : board) {
            Arrays.fill(row, '.'); // initially every cell is empty
        }

        boolean[] columns = new boolean[n]; // track occupied columns
        boolean[] diagonals1 = new boolean[2 * n - 1]; // track "\" diagonals
        boolean[] diagonals2 = new boolean[2 * n - 1]; // track "/" diagonals

        backtrack(0, n, board, columns, diagonals1, diagonals2, result); // start from row 0

        return result; // return every valid configuration
    }

    private void backtrack(
            int row,
            int n,
            char[][] board,
            boolean[] columns,
            boolean[] diagonals1,
            boolean[] diagonals2,
            List<List<String>> result) {

        if (row == n) { // all rows have a queen
            List<String> solution = new ArrayList<>(); // create one board
            for (char[] r : board) {
                solution.add(new String(r)); // convert each row to String
            }
            result.add(solution); // save the valid board
            return; // stop this branch
        }

        for (int col = 0; col < n; col++) { // try every column in this row

            int d1 = row - col + n - 1; // map "\" diagonal to valid index
            int d2 = row + col; // map "/" diagonal to valid index

            if (columns[col] || diagonals1[d1] || diagonals2[d2]) {
                continue; // position is attacked, so skip it
            }

            board[row][col] = 'Q'; // place queen
            columns[col] = true; // mark column as occupied
            diagonals1[d1] = true; // mark "\" diagonal as occupied
            diagonals2[d2] = true; // mark "/" diagonal as occupied

            backtrack(row + 1, n, board, columns, diagonals1, diagonals2, result); // solve next row

            board[row][col] = '.'; // remove queen during backtracking
            columns[col] = false; // free the column
            diagonals1[d1] = false; // free the "\" diagonal
            diagonals2[d2] = false; // free the "/" diagonal
        }
    }
}