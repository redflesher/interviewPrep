// https://leetcode.com/problems/3sum/description/
package leet.code.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int target = 0; target < nums.length - 1; target++) {
            if (target != 0 && nums[target] == nums[target - 1])
                continue;
            int lowIndex = target + 1;
            int highIndex = nums.length - 1;

            while (lowIndex < highIndex) {
                int sum = nums[lowIndex] + nums[highIndex];
                if (sum == -nums[target]) {
                    result.add(List.of(nums[target], nums[lowIndex], nums[highIndex]));
                    while (lowIndex < highIndex && nums[lowIndex] == nums[lowIndex + 1])
                        lowIndex++;
                    while (lowIndex < highIndex && nums[highIndex] == nums[highIndex - 1])
                        highIndex--;
                    lowIndex++;
                    highIndex--;
                }
                else if (sum < -nums[target])
                    lowIndex++;
                else
                    highIndex--;
            }
        }

        return result;
    }
}
