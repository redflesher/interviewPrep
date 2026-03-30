// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
package leet.code.graph.union_find;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        int n = 20002;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] stone : stones) {
            union(parent, rank, stone[0], stone[1] + 10001);
        }

        for (int[] stone : stones) {
            int rootRow = findRoot(parent, stone[0]);
            if (stone[0] == rootRow)
                result.add(rootRow);
            int rootColumn = findRoot(parent, stone[1]);
            if (stone[0] == rootColumn)
                result.add(rootColumn);
        }

        return stones.length - result.size();
    }

    private int findRoot (int[] parent, int node) {
        if (parent[node] != node)
            parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }

    private void union (int[] parent, int[] rank, int a, int b) {
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
