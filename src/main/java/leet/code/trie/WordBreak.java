// https://leetcode.com/problems/word-break/description/
package leet.code.trie;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (String item : wordDict) {
            trie.addWord(item);
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    if (trie.isPartOfTrie(s, j, i)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    private class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void addWord(String word) {
            Trie currentTrie = this;
            for (int i = 0; i < word.length(); i++) {
                if (currentTrie.children[word.charAt(i) - 'a'] == null)
                    currentTrie.children[word.charAt(i) - 'a'] = new Trie();
                currentTrie = currentTrie.children[word.charAt(i) - 'a'];
            }
            currentTrie.isEnd = true;
        }

        public boolean isPartOfTrie(String s, int from, int to) {
            Trie currentTrie = this;
            for (int i = from; i < to; i++) {
                if (currentTrie.children[s.charAt(i) - 'a'] != null)
                    currentTrie = currentTrie.children[s.charAt(i) - 'a'];
                else
                    return false;
            }

            return currentTrie.isEnd;
        }
    }
}
