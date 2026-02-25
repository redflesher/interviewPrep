// https://leetcode.com/problems/merge-intervals/description/
package leet.code.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }
            else {
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }
}
