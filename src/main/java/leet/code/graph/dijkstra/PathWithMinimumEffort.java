// https://leetcode.com/problems/path-with-minimum-effort/description/
package leet.code.graph.dijkstra;

import java.util.*;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int[][] distance = new int[heights.length][heights[0].length];

        queue.offer(new int[] {0, 0, 0});

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] currentNodeWithMaxEffort = queue.poll();
            int row = currentNodeWithMaxEffort[0];
            int column = currentNodeWithMaxEffort[1];
            int currentMaxEffort = currentNodeWithMaxEffort[2];

            if (currentMaxEffort > distance[row][column])
                continue;

            if (row == heights.length -1 && column == heights[heights.length-1].length-1)
                return currentMaxEffort;

            for (int[] direction : directions) {
                int neighborRow = row + direction[0];
                int neighborColumn = column + direction[1];
                if (neighborRow >= 0 &&
                        neighborRow < heights.length &&
                        neighborColumn >= 0 &&
                        neighborColumn < heights[neighborRow].length) {
                    int newEffort = Math.max(currentMaxEffort, Math.abs(heights[row][column] - heights[neighborRow][neighborColumn]));
                    if (newEffort < distance[neighborRow][neighborColumn]) {
                        distance[neighborRow][neighborColumn] = newEffort;
                        queue.offer(new int[]{neighborRow, neighborColumn, newEffort});
                    }
                }
            }
        }

        return -1;
    }
}
