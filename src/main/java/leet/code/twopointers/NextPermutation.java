// https://leetcode.com/problems/next-permutation/description/
package leet.code.twopointers;

public class NextPermutation {
    // 2531
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            int j = n - 1;
            while (nums[i] >= nums[j])
                j--;

            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);


    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void reverse (int[] nums, int left, int right) {
        while (left < right){
            swap(nums, left++, right--);
        }
    }
}
