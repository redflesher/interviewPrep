// https://leetcode.com/problems/palindrome-partitioning/description/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i < s.length(); i++) {
                int start = i;
                int end = i + length - 1;
                if (end > s.length()-1)
                    continue;

                if (length == 1) {
                    isPalindrome[start][end] = true;
                    continue;
                }

                if (length == 2 && s.charAt(start) == s.charAt(end)) {
                    isPalindrome[start][end] = true;
                    continue;
                }
                if (length >= 3 && s.charAt(start) == s.charAt(end) && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                    continue;
                }
            }
        }

        backtrack(0, s, result, new ArrayList<>(), isPalindrome);

        return result;
    }

    private void backtrack(int startIndex,
                           String s,
                           List<List<String>> result,
                           List<String> currentPalindromeList,
                           boolean[][] isPalindrome
    ) {

        if (startIndex == s.length())
            result.add(new ArrayList<>(currentPalindromeList));

        for (int i = startIndex; i < s.length(); i++) {
            String currentSubstring = s.substring(startIndex, i + 1);
            if (isPalindrome[startIndex][i]) {
                currentPalindromeList.add(currentSubstring);
                backtrack(i + 1, s, result, currentPalindromeList, isPalindrome);
                currentPalindromeList.remove(currentPalindromeList.size() - 1);
            }
        }
    }
    /*
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(0, s, result, new ArrayList<>());

        return result;
    }

    private void backtrack(int startIndex,
                           String s,
                           List<List<String>> result,
                           List<String> currentPalindromeList
    ) {

        if (startIndex == s.length())
            result.add(new ArrayList<>(currentPalindromeList));

        for (int i = startIndex; i < s.length(); i++) {
            String currentSubstring = s.substring(startIndex, i + 1);
            if (isPalindrome(currentSubstring)) {
                currentPalindromeList.add(currentSubstring);
                backtrack(i + 1, s, result, currentPalindromeList);
                currentPalindromeList.remove(currentPalindromeList.size() - 1);
            }
        }
    }

    private boolean isPalindrome (String str) {
        for (int i = 0, j = str.length()-1; i < str.length(); i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }*/
}
