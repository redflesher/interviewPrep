// https://leetcode.com/problems/word-search-ii/description/
package leet.code.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] usedBoard = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();

        for (String word : words) {
            trie.addWord(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                StringBuilder sb = new StringBuilder();
                if (trie.children[board[row][column] - 'a'] != null) {
                    sb.append(board[row][column]);
                    usedBoard[row][column] = true;
                    dsf(row, column, board, usedBoard, directions, trie.children[board[row][column] - 'a'], sb, result);
                    sb.deleteCharAt(sb.length() - 1);
                    usedBoard[row][column] = false;
                }
            }
        }

        return result;
    }

    private void dsf(int row,
                     int column,
                     char[][] board,
                     boolean[][] usedBoard,
                     int[][] directions,
                     Trie trie,
                     StringBuilder sb,
                     List<String> result
    ) {
        if (trie.isEnd) {
            result.add(sb.toString());
            trie.isEnd = false;
        }

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if (newRow < board.length && newRow >= 0 &&
                    newColumn < board[newRow].length && newColumn >= 0) {
                if (trie.children[board[newRow][newColumn] - 'a'] != null && !usedBoard[newRow][newColumn]) {
                    sb.append(board[newRow][newColumn]);
                    usedBoard[newRow][newColumn] = true;
                    dsf(newRow, newColumn, board, usedBoard, directions, trie.children[board[newRow][newColumn] - 'a'], sb, result);
                    if (trie.children[board[newRow][newColumn] - 'a'].isEmpty())
                        trie.children[board[newRow][newColumn] - 'a'] = null;
                    sb.deleteCharAt(sb.length() - 1);
                    usedBoard[newRow][newColumn] = false;
                }
            }
        }

    }

    private class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void addWord(String word) {
            Trie currentTrie = this;
            for (int i = 0; i < word.length(); i++) {
                if (currentTrie.children[word.charAt(i) - 'a'] == null)
                    currentTrie.children[word.charAt(i) - 'a'] = new Trie();
                currentTrie = currentTrie.children[word.charAt(i) - 'a'];
            }
            currentTrie.isEnd = true;
        }

        public boolean isEmpty() {
            for (Trie child : this.children) {
                if (child != null)
                    return false;
            }

            return !isEnd;
        }
    }
}
