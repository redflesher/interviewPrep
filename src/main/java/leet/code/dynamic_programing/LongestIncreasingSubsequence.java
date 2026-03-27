// https://leetcode.com/problems/longest-increasing-subsequence/description/
package leet.code.dynamic_programing;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int low = 0;
            int high = tails.size();

            // binary search for leftmost position where tails[mid] >= num
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tails.get(mid) < num)
                    low = mid + 1;
                else
                    high = mid;
            }

            if (low == tails.size())
                tails.add(num); // num is larger than all tails, extend
            else
                tails.set(low, num); // replace to keep tails as small as possible
        }

        return tails.size();

        /*int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }

        return result;*/
    }
}
