// https://leetcode.com/problems/subsets-ii/description/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), 0 , nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> currentList,
                           int start,
                           int[] nums
    ) {
        result.add(new ArrayList<>(currentList));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1])
                continue;
            else {
                currentList.add(nums[i]);
                backtrack(result, currentList, i+1, nums);
                currentList.remove(Integer.valueOf(nums[i]));
            }
        }

    }
}
