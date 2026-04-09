// https://leetcode.com/problems/find-median-from-data-stream/description/
package leet.code.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> lowerHalf = new PriorityQueue<>();
    private final Queue<Integer> upperHalf = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    public void addNum(int num) {
        lowerHalf.offer(num);
        upperHalf.offer(lowerHalf.poll());

        if (upperHalf.size() > lowerHalf.size())
            lowerHalf.offer(upperHalf.poll());
    }

    public double findMedian() {
        int nMax = upperHalf.size();
        int nMin = lowerHalf.size();

        if (nMin > nMax)
            return (double) lowerHalf.peek();
        else if (nMin < nMax)
            return (double) upperHalf.peek();
        else
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
    }
}
