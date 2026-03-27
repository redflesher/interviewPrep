// https://leetcode.com/problems/swim-in-rising-water/description/
package leet.code.graph.dijkstra;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] directions = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
        int[][] elevations = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                elevations[i][j] = Integer.MAX_VALUE;
            }
        }
        elevations[0][0] = grid[0][0];

        queue.offer(new int[] {0,0, grid[0][0]});

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int currentRow = currentCell[0];
            int currentColumn = currentCell[1];
            int currentElevation = currentCell[2];

            if (currentElevation > elevations[currentRow][currentColumn])
                continue;

            if (currentRow == rows -1 && currentColumn == columns -1)
                return currentElevation;

            for (int[] direction : directions) {
                int neighbourRow = currentRow + direction[0];
                int neighbourColumn = currentColumn + direction[1];

                if (neighbourRow >= 0 &&
                        neighbourRow < rows &&
                        neighbourColumn >= 0 &&
                        neighbourColumn < columns) {
                    int newMaxElevation = Math.max(currentElevation, grid[neighbourRow][neighbourColumn]);
                    if (newMaxElevation < elevations[neighbourRow][neighbourColumn]) {
                        elevations[neighbourRow][neighbourColumn] = newMaxElevation;
                        queue.offer(new int[] {neighbourRow, neighbourColumn, newMaxElevation});
                    }
                }
            }
        }

        return -1;
    }
}
