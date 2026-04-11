// https://leetcode.com/problems/task-scheduler/
package leet.code.heap;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new ArrayDeque<>();

        int[] frequency = new int[26];
        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        for (int item : frequency) {
            if (item > 0)
                priorityQueue.offer(item);
        }

        int i = 0;

        while (!priorityQueue.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && queue.peek()[1] == i)
                priorityQueue.offer(queue.poll()[0]);

            Integer current = priorityQueue.poll();
            if (current != null && current -1 > 0)
                queue.offer(new int[] {current -1, i + n + 1});

            i++;
        }

        return i;
    }
}
