// https://leetcode.com/problems/combination-sum-ii/description/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, target, candidates, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start,
                           int remainingTarget,
                           int[] candidates,
                           List<Integer> currentList,
                           List<List<Integer>> result
    ) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (remainingTarget < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            else {
                currentList.add(candidates[i]);
                backtrack(i + 1, remainingTarget - candidates[i], candidates, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }

    }
}
