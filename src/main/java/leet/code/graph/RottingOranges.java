// https://leetcode.com/problems/rotting-oranges/description/
package leet.code.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new ArrayDeque<>();
        int depth = 0;
        int freshCount = 0;
        int cols = grid[0].length;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 2)
                    queue.offer(encode(row, column, cols));
                if (grid[row][column] == 1)
                    freshCount++;
            }
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentFreshCount = freshCount;
            for (int i = 0; i < levelSize; i++) {
                int currentCoordinates = queue.poll();
                int row = decodeRow(currentCoordinates, cols);
                int column = decodeColumn(currentCoordinates, cols);
                if (row + 1 < grid.length && helper(grid, queue, row + 1, column)) {
                    freshCount--;
                }
                if (row - 1 >= 0 && helper(grid, queue, row - 1, column)) {
                    freshCount--;
                }
                if (column + 1 < grid[row].length && helper(grid, queue, row, column + 1)) {
                    freshCount--;
                }
                if (column - 1 >= 0 && helper(grid, queue, row, column - 1)) {
                    freshCount--;
                }
            }
            if (currentFreshCount != freshCount)
                depth++;
        }

        return freshCount == 0 ? depth : -1;
    }



    private static boolean helper (int[][] grid, Queue<Integer> queue, int row, int column) {
        if (grid[row][column] == 1) {
            grid[row][column] = 2;
            queue.offer(encode(row, column, grid[0].length));
            return true;
        }
        return false;
    }

    private static int decodeColumn(int currentCoordinates, int cols) {
        return currentCoordinates % cols;
    }

    private static int decodeRow(int currentCoordinates, int cols) {
        return currentCoordinates / cols;
    }

    private static int encode(int row, int column, int cols) {
        return row * cols + column;
    }
}

