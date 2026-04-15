// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] digitsAsChars = digits.toCharArray();

        backtrack(0, digitsAsChars, mapping, sb, result);

        return result;
    }

    private void backtrack(int currentCharIndex,
                           char[] digitsAsChars,
                           String[] mapping,
                           StringBuilder sb,
                           List<String> result

    ) {
        if (sb.length() == digitsAsChars.length) {
            result.add(sb.toString());
            return;
        }

        if (currentCharIndex >= digitsAsChars.length)
            return;
        int currentChar = digitsAsChars[currentCharIndex] - '0';
        char[] currentMapping = mapping[currentChar].toCharArray();
        for (char item : currentMapping) {
            sb.append(item);
            backtrack(currentCharIndex + 1, digitsAsChars, mapping, sb, result);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}
