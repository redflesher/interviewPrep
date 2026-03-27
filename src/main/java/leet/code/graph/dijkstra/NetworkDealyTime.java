// https://leetcode.com/problems/network-delay-time/description/
package leet.code.graph.dijkstra;

import java.util.*;

public class NetworkDealyTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        List<List<int[]>> adjacencyList = new ArrayList<>();
        int[] distance = new int[n + 1];
        int result = 0;

        queue.offer(new int[] {k, 0});

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adjacencyList.get(time[0]).add(new int[] {time[1], time[2]});
        }

        while (!queue.isEmpty()) {
            int[] currentNodeWithDistance = queue.poll();
            int currentNode = currentNodeWithDistance[0];
            int currentDistance = currentNodeWithDistance[1];

            for (int[] neighbourWithWeight : adjacencyList.get(currentNode)) {
                int neighbour = neighbourWithWeight[0];
                int weight = neighbourWithWeight[1];
                if (currentDistance + weight < distance[neighbour]) {
                    distance[neighbour] = currentDistance + weight;
                    queue.offer(new int [] {neighbour, distance[neighbour]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                return -1;
            result = Math.max(result, distance[i]);
        }

        return result;
    }
}
