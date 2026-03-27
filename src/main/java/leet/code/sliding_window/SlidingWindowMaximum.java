// https://leetcode.com/problems/sliding-window-maximum/description/
package leet.code.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length -k+1];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < currentNumber)
                deque.pollLast();
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() < (i - k + 1))
                deque.pollFirst();
            if (i >= k-1)
                result[j++] = nums[deque.peekFirst()];
        }

        return result;
    }
}
