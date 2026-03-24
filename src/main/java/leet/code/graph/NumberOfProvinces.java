// https://leetcode.com/problems/number-of-provinces/description/
package leet.code.graph;

import java.util.Arrays;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        int count = 0;
        for (int node = 0; node < isConnected.length; node++) {
            if (!visited[node]) {
                helper(visited, isConnected, node);
                count++;
            }
        }

        return count;
    }

    private static void helper(boolean[] visited, int[][] isConnected, int node){
        visited[node] = true;
        for (int neighbour = 0; neighbour < isConnected[node].length; neighbour++) {
            if (isConnected[node][neighbour] == 1 && !visited[neighbour])
                helper(visited, isConnected, neighbour);
        }
    }
}
