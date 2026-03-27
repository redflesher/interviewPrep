// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// not real dijkstra!!
package leet.code.graph.dijkstra;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build adjacency list
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjacencyList.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        // Step 2: Initialize distance array and queue
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<int[]> queue = new LinkedList<>(); // {node, costSoFar}
        queue.add(new int[]{src, 0});

        int stops = 0; // overall stops counter

        // Step 3: BFS with stops
        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int node = current[0];
                int cost = current[1];

                // Explore neighbors
                for (int[] neighbor : adjacencyList.get(node)) {
                    int nextNode = neighbor[0];
                    int price = neighbor[1];

                    // Update distance and add to queue if cheaper
                    if (cost + price < distance[nextNode]) {
                        distance[nextNode] = cost + price;
                        queue.add(new int[]{nextNode, cost + price});
                    }
                }
            }

            stops++; // increment overall stops after processing this level
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    /*{
        Queue<int[]> pr = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        List<List<int[]>> adjacencyList = new ArrayList<>();
        int[][] distanceAndStops = new int[n][k + 2];
        int result = 0;

        pr.offer(new int[] {src, 0, 0});

        for (int i = 0; i < n; i++) {
            Arrays.fill(distanceAndStops[i], Integer.MAX_VALUE);
        }
        distanceAndStops[src][0] = 0;

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjacencyList.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        while (!pr.isEmpty()) {
            int[] currentNodeWithDist = pr.poll();
            int currentNode = currentNodeWithDist[0];
            int currentDistance = currentNodeWithDist[1];
            int currentStops = currentNodeWithDist[2];

            for (int[] neighbourWithWeight : adjacencyList.get(currentNode)) {
                int neighbour = neighbourWithWeight[0];
                int weight = neighbourWithWeight[1];
                int nextCost = currentDistance + weight;
                int nextStops  = currentStops + 1;
                if (nextStops <= k + 1) {
                    if (nextCost < distanceAndStops[neighbour][nextStops]) {
                        distanceAndStops[neighbour][nextStops] = nextCost;
                        pr.offer(new int[]{neighbour, nextCost, nextStops});
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int stops = 1; stops <= k + 1; stops++) {
            minCost = Math.min(minCost, distanceAndStops[dst][stops]);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }*/
}
