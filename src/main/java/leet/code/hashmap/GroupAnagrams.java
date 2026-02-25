// https://leetcode.com/problems/group-anagrams/description/
package leet.code.hashmap;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String item : strs) {
            int[] count = new int[26];
            for (char c : item.toCharArray()) {
                int position = c - 'a';
                count[position]++;
            }

            String key = Arrays.toString(count);

            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }

        return anagrams.values().stream().toList();
    }
}
