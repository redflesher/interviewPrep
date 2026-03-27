// https://leetcode.com/problems/house-robber-ii/description/
package leet.code.dynamic_programing;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int maxWithoutLast = helper(0, nums.length-2, nums);
        int maxWithoutFirst = helper(1, nums.length-1, nums);

        return Math.max(maxWithoutLast, maxWithoutFirst);
    }

    private int helper(int first,int last, int[] nums) {
        int prev2 = nums[first];
        int prev1 = Math.max(nums[first], nums[first + 1]);

        for (int i = first + 2; i <= last; i++) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
