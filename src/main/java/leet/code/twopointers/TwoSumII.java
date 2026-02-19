//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
package leet.code.twopointers;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lowIndex = 0;
        int highIndex = numbers.length - 1;

        while (numbers[lowIndex] + numbers[highIndex] != target) {
            if (numbers[lowIndex] + numbers[highIndex] > target) {
                highIndex--;
            } else // if (numbers[lowIndex] + numbers[highIndex] < target)
            {
                lowIndex++;
            }
        }
        return new int[]{lowIndex + 1, highIndex + 1};
    }
}
