// https://leetcode.com/problems/minimum-size-subarray-sum/
package leet.code.sliding_window;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int startIndex = 0;
        int sum = 0;


        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            sum += nums[endIndex];
            while (sum >= target) {
                result = Math.min(result, endIndex - startIndex + 1);
                sum -= nums[startIndex++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
