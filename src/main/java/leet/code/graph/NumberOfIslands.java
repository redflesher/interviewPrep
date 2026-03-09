// https://leetcode.com/problems/number-of-islands/description/
package leet.code.graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    helper(grid, row, column);
                    count++;
                }
            }
        }

        return count;
    }

    private void helper(char[][] grid, int row, int column) {
        grid[row][column] = '0';

        if (row + 1 < grid.length && grid[row + 1][column] == '1')
                helper(grid, row + 1, column);

        if (column + 1  < grid[row].length && grid[row][column + 1] == '1')
                helper(grid, row, column + 1);

        if (row - 1 >= 0 && grid[row - 1][column] == '1')
                helper(grid, row - 1, column);

        if (column - 1 >= 0 && grid[row][column - 1] == '1')
                helper(grid, row, column - 1);

    }
}
