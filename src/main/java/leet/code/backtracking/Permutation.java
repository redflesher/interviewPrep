// https://leetcode.com/problems/permutations/description/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, new ArrayList<>(), used);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentPermutation, boolean[] used) {
        if (currentPermutation.size() == nums.length)
            result.add(new ArrayList<>(currentPermutation));
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currentPermutation.add(nums[i]);
                used[i] = true;
                backtrack(nums, result, currentPermutation, used);
                currentPermutation.remove(Integer.valueOf(nums[i]));
                used[i] = false;
            }
        }
    }
}
