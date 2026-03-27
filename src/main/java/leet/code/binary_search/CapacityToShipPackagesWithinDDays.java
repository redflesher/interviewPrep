// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
package leet.code.binary_search;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for (int weight : weights) {
            high += weight;
        }
        for (int weight : weights) {
            low = Math.max(weight, low);
        }

        while (low != high) {
            int mid = low + (high - low) / 2;

            if (canCarryAllAtCapacity(weights, days, mid))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private boolean canCarryAllAtCapacity(int[] weights, int days, int capacity) {
        int totalDays = 0;
        int currentCapacity = 0;
        for (int weight : weights) {
            currentCapacity += weight;
            if (currentCapacity > capacity) {
                totalDays++;
                currentCapacity = weight;
            }
        }
        if (currentCapacity > 0)
            totalDays++;

        return totalDays <= days;
    }
}
