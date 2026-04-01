// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
package leet.code.graph.union_find;

public class NumberOfOperationToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (n -1 > connections.length)
            return -1;
        int[] parents = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 0;
        }

        for (int[] connection : connections) {
            int rootA = findRoot(parents, connection[0]);
            int rootB = findRoot(parents, connection[1]);
            if (rootA != rootB) {
                union(parents, rank, connection[0], connection[1]);
                n--;
            }
        }

        return n;
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] != node)
            parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }

    private void union(int[] parent, int[] rank, int a, int b) {
        int rootA = findRoot(parent, a);
        int rootB = findRoot(parent, b);

        if (rank[rootA] > rank[rootB])
            parent[rootB] = rootA;
        else if (rank[rootB] > rank[rootA])
            parent[rootA] = rootB;
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
