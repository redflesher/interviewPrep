// https://leetcode.com/problems/reorganize-string/description/
package leet.code.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        int maxFreq = Integer.MIN_VALUE;

        for (int i = 0; i < frequencies.length; i++) {
            if (maxFreq < frequencies[i])
                maxFreq = frequencies[i];
            if (frequencies[i] > 0)
                priorityQueue.offer(new int[] {i, frequencies[i]});

        }
        if (maxFreq > (s.length() + 1) / 2)
            return "";

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int[] currentCharWithFreq = priorityQueue.poll();
            char currentChar = (char) (currentCharWithFreq[0] + 'a');
            int currentFreq = currentCharWithFreq[1];
            if (sb.isEmpty() || sb.charAt(sb.length() -1) != currentChar) {
                sb.append(currentChar);
                if (currentFreq - 1 > 0)
                    priorityQueue.offer(new int[] {currentCharWithFreq[0], currentFreq -1});

            } else {
                if (!priorityQueue.isEmpty()) {
                    int[] previousCharWithFreq = priorityQueue.poll();
                    char previousChar = (char) (previousCharWithFreq[0] + 'a');
                    int previousFreq = previousCharWithFreq[1];
                    sb.append(previousChar);
                    priorityQueue.offer(new int[] {currentCharWithFreq[0], currentFreq});
                    if (previousFreq - 1 > 0)
                        priorityQueue.offer(new int[]{previousCharWithFreq[0], previousFreq - 1});
                }
                else
                    return "";
            }
        }

        return sb.toString();
    }
}
