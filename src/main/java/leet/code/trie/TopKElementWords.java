// https://leetcode.com/problems/top-k-frequent-words/description/
package leet.code.trie;

import java.util.*;

public class TopKElementWords {
    public List<String> topKFrequent(String[] words, int k) {
        Queue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue()))
                return b.getKey().compareTo(a.getKey());
            return a.getValue() - b.getValue();
        });
        Map<String, Integer> wordsMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }

        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(result);

        return result;
    }
}
