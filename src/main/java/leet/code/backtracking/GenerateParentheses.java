// https://leetcode.com/problems/generate-parentheses/description/
package leet.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(new StringBuilder(), n, 0, 0, result);

        return result;
    }

    private void backtrack(StringBuilder sb,
                           int n,
                           int left,
                           int right,
                           List<String> result
    ) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            backtrack(sb, n, left + 1, right, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(')');
            backtrack(sb, n, left, right + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
