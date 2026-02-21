// https://leetcode.com/problems/sliding-window-maximum/description/
package leet.code.slidingwindow;

import java.util.Arrays;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int currentMax = nums[0];

        currentMax = findMax(Arrays.copyOfRange(nums, 0, k));

        int[] result = new int[nums.length - k +1];
        int i = 0;
        result[i++] = currentMax;

        for (int start = 0; start + k < nums.length; start++) {
            if (nums[start + k] > currentMax)
                currentMax = nums[start + k];
            else if (nums[start] == currentMax)
                currentMax = findMax(Arrays.copyOfRange(nums, start + 1, start + 1 + k));

            result[i++] = currentMax;
        }


        return result;
    }

    private static int findMax(int[] nums) {
        int currentMax = Integer.MIN_VALUE;
        for (int num : nums) {
            currentMax = Math.max(num, currentMax);
        }
        return currentMax;
    }
}
