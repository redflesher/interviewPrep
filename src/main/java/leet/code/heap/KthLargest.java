// https://leetcode.com/problems/kth-largest-element-in-a-stream/
package leet.code.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    private final Queue<Integer> priorityQueue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.offer(num);
        }

        while (priorityQueue.size() > k)
            priorityQueue.poll();
    }

    public int add(int val) {
        if (!priorityQueue.isEmpty()) {
            if (val > priorityQueue.peek() || priorityQueue.size() < k)
                priorityQueue.offer(val);
        } else
            priorityQueue.offer(val);

        while (priorityQueue.size() > k)
            priorityQueue.poll();

        return priorityQueue.peek();
    }
}
