// https://leetcode.com/problems/container-with-most-water/description/
package leet.code.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int maxHeight = Math.min(height[left], height[right]);
            int currentArea = maxHeight * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else
                right--;
        }

        return maxArea;
    }
}
