// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
package leet.code.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> a - b);
        priorityQueue.offer(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int currentNumber = nums[i];
            int head = priorityQueue.peek();
            if (priorityQueue.size() == k) {
                if (currentNumber > head) {
                    priorityQueue.poll();
                    priorityQueue.offer(currentNumber);
                }
            } else {
                priorityQueue.offer(currentNumber);
            }
        }

        return priorityQueue.poll();
    }
}
