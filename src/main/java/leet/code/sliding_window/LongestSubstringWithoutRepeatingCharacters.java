// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
package leet.code.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char character = s.charAt(end);
            if (map.containsKey(character)) {
                start = Math.max(start, map.get(character) +1);
            }
            map.put(character, end);
            maxLength = Math.max(maxLength, (end - start +1));
        }

        return maxLength;
    }
}
