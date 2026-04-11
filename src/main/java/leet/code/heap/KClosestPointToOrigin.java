// https://leetcode.com/problems/k-closest-points-to-origin/
package leet.code.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for (int i = 0; i < points.length; i++) {
            double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            if (priorityQueue.size() < k)
                priorityQueue.offer(points[i]);
            else {
                double currentPeek = Math.pow(priorityQueue.peek()[0], 2) + Math.pow(priorityQueue.peek()[1], 2);
                if (distance < currentPeek) {
                    priorityQueue.poll();
                    priorityQueue.offer(points[i]);
                }
            }
        }

        return priorityQueue.toArray(new int[k][]);
    }
}
