// https://leetcode.com/problems/maximum-average-subarray-i/description/
package leet.code.sliding_window;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAverage = (double) sum / k;


        for (int start = 0; start + k < nums.length; start++) {
            sum = (sum - nums[start] + nums[start + k]);
            maxAverage = Math.max(maxAverage, (double) sum / k);
        }

        return maxAverage;
    }
}
