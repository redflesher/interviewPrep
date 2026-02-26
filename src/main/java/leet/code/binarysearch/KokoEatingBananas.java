// https://leetcode.com/problems/koko-eating-bananas/
package leet.code.binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low != high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, mid, h))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int sumHours = 0;
        for (int pile : piles) {
            sumHours += (pile + k -1) / k;
        }
        return sumHours <= h;
    }
}
