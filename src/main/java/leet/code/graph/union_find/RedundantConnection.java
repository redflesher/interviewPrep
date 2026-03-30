// https://leetcode.com/problems/redundant-connection/description/
package leet.code.graph.union_find;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] parent = new int[n];
        int[] rank = new int[n];
        int[] result = new int[2];

        for (int i = 1; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int rootA = findRoot(parent, edge[0]);
            int rootB = findRoot(parent, edge[1]);
            if (rootA != rootB)
                union(parent, rank, edge[0], edge[1]);
            else
                result = edge;
        }

        return result;
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] != node)
            parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }

    private void union (int[] parent, int[] rank, int a, int b) {
        int rootA = findRoot(parent, a);
        int rootB = findRoot(parent, b);

        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
