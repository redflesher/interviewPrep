// https://leetcode.com/problems/3sum/description/
package leet.code.twopointers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class _3Sum {
    // [-4, -1, -1, 0, 1, 2]
    public static List<List<Integer>> threeSum(int[] nums) {
        mergeSort(nums, nums.length);

        Set<List<Integer>> returnList = new HashSet<>();

        for (int target = 0; target < nums.length - 1; target++) {
            if (target != 0)
                if (nums[target] == nums[target -1])
                    continue;
            int lowIndex = 0;
            int highIndex = nums.length - 1;

            while (lowIndex < highIndex) {
                if (target == lowIndex) {
                    lowIndex++;
                    continue;
                }
                if (target == highIndex) {
                    highIndex--;
                    continue;
                }
                if (nums[lowIndex] + nums[highIndex] == -nums[target]) {
                    int[] x = new int[] {nums[target], nums[lowIndex], nums[highIndex]};
                    mergeSort(x, 3);
                    returnList.add(List.of(x[0], x[1], x[2]));
                }
                if (nums[lowIndex] + nums[highIndex] < -nums[target])
                    lowIndex++;
                else
                    highIndex--;
            }
        }

        return returnList.stream().toList();
    }

    private static void mergeSort(int[] nums, int n) {
        if (n < 2)
            return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = nums[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(nums, left, right, mid, n - mid);

    }

    private static void merge(int[] nums, int[] left, int[] right, int l, int r) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l && j < r) {
            if (left[i] <= right[j])
                nums[k++] = left[i++];
            else
                nums[k++] = right[j++];
        }
        while (i < l)
            nums[k++] = left[i++];
        while (j < r)
            nums[k++] = right[j++];
    }
}
