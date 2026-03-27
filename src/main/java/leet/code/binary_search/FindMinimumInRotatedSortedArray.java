// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
package leet.code.binary_search;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        while (low != high) {
            int mid = low + (high - low) /2;

            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }

        return nums[low];
    }
}
