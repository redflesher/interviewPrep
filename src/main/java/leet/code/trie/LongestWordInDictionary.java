// https://leetcode.com/problems/longest-word-in-dictionary/description/
package leet.code.trie;

public class LongestWordInDictionary {
    private String currentMax = "";

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.addWord(word);
        }
        trie.isEnd = true;
        dsf(trie, new StringBuilder());

        return currentMax;
    }

    private void dsf(Trie currentTrie, StringBuilder sb) {
        if (currentTrie.isEnd) {
            if (sb.length() > currentMax.length())
                currentMax = sb.toString();
            for (int i = 0; i < currentTrie.children.length; i++) {
                if (currentTrie.children[i] != null) {
                    sb.appendCodePoint(i + 'a');
                    dsf(currentTrie.children[i], sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
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
                int index = word.charAt(i) - 'a';
                if (currentTrie.children[index] == null)
                    currentTrie.children[index] = new Trie();
                currentTrie = currentTrie.children[index];
            }
            currentTrie.isEnd = true;
        }
    }
}
