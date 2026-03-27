// https://leetcode.com/problems/number-of-provinces/description/
package leet.code.graph.union_find;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1)
                    union(parent, rank, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            resultSet.add(findRoot(parent, i));
        }

        return resultSet.size();
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findRoot(parent, parent[node]);
        }
        return parent[node];
    }

    private void union(int[] parent, int[] rank, int a, int b) {
        int rootA = findRoot(parent, a);
        int rootB = findRoot(parent, b);
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
