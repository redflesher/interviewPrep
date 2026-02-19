// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
package leet.code.twopointers;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int uniqNumber = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[uniqNumber])
                continue;
            else {
                nums[++uniqNumber] = nums[i];
            }
        }
        return uniqNumber +1;
    }
}
