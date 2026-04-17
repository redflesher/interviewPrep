// https://leetcode.com/problems/word-search/
package leet.code.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        char[] chars = word.toCharArray();

        if (m * n < word.length())
            return false;

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] == chars[0]) {
                    char tmp = board[row][column];
                    board[row][column] = '#';
                    result = backtrack(1, row, column, board, chars, result, directions);
                    if (result)
                        return true;
                    else
                        board[row][column] = tmp;
                }
            }
        }
        return false;

    }

    private boolean backtrack(int charsIndex,
                              int row,
                              int column,
                              char[][] board,
                              char[] chars,
                              boolean result,
                              int[][] directions
    ) {
        if (charsIndex == chars.length)
            return true;

        char currentChar = chars[charsIndex];

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if (newRow >= 0 && newRow < board.length &&
                    newColumn >= 0 && newColumn < board[newRow].length &&
                    board[newRow][newColumn] == currentChar &&
                    board[newRow][newColumn] != '#'
            ) {
                char tmp = board[newRow][newColumn];
                board[newRow][newColumn] = '#';
                result = backtrack(charsIndex + 1, newRow, newColumn, board, chars, result, directions);
                board[newRow][newColumn] = tmp;
                if (result)
                    return true;
            }
        }

        return result;
    }

    /*public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        char[] chars = word.toCharArray();

        if (m * n < word.length())
            return false;

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] == chars[0]) {
                    char tmp = board[row][column];
                    board[row][column] = '#';
                    result = backtrack(1, row, column, board, chars, result);
                    if (result)
                        return true;
                    else
                        board[row][column] = tmp;
                }
            }
        }
        return false;

    }

    private boolean backtrack(int charsIndex,
                              int row,
                              int column,
                              char[][] board,
                              char[] chars,
                              boolean result
    ) {
        if (charsIndex == chars.length)
            return true;

        char currentChar = chars[charsIndex];

        if (row - 1 >= 0 && board[row - 1][column] == currentChar && board[row - 1][column] != '#') {
            char tmp = board[row - 1][column];
            board[row - 1][column] = '#';
            result = backtrack(charsIndex + 1, row - 1, column, board, chars, result);
            board[row - 1][column] = tmp;
            if (result)
                return true;
        }
        if (row + 1 < board.length && board[row + 1][column] == currentChar && board[row + 1][column] != '#') {
            char tmp = board[row + 1][column];
            board[row + 1][column] = '#';
            result = backtrack(charsIndex + 1, row + 1, column, board, chars, result);
            board[row + 1][column] = tmp;
            if (result)
                return true;
        }
        if (column - 1 >= 0 && board[row][column - 1] == currentChar && board[row][column - 1] != '#') {
            char tmp = board[row][column - 1];
            board[row][column - 1] = '#';
            result = backtrack(charsIndex + 1, row, column - 1, board, chars, result);
            board[row][column - 1] = tmp;
            if (result)
                return true;
        }
        if (column + 1 < board[row].length && board[row][column + 1] == currentChar && board[row][column + 1] != '#') {
            char tmp = board[row][column + 1];
            board[row][column + 1] = '#';
            result = backtrack(charsIndex + 1, row, column + 1, board, chars, result);
            board[row][column + 1] = tmp;
            if (result)
                return true;
        }

        return result;
    }*/
}
