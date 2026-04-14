// https://leetcode.com/problems/combination-sum/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, result, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates,
                           int remainingTarget,
                           int start,
                           List<List<Integer>> result,
                           List<Integer> currentCombination
    ) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (remainingTarget < 0){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            backtrack(candidates, remainingTarget - candidates[i], i, result, currentCombination);
            currentCombination.remove(Integer.valueOf(candidates[i]));
        }
    }
}
