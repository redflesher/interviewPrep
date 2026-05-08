// https://leetcode.com/problems/short-encoding-of-words/description/
package leet.code.trie;

public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.addWord(word);
        }

        return dsf(trie, 0, 0);

    }

    private int dsf(Trie currrentTrie, int depth, int result) {

        for (int i = 0; i < currrentTrie.children.length; i++) {
            if (currrentTrie.children[i] != null) {
                result = dsf(currrentTrie.children[i], depth + 1, result);
                if (currrentTrie.children[i].isEnd) {
                    result += depth + 2;
                }
                currrentTrie.isEnd = false;
            }
        }
        return result;
    }

    private class Trie {
        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void addWord(String word) {
            Trie currentTrie = this;
            for (int i = word.length()-1; i >= 0; i--) {
                if (currentTrie.children[word.charAt(i) - 'a'] == null)
                    currentTrie.children[word.charAt(i) - 'a'] = new Trie();
                currentTrie = currentTrie.children[word.charAt(i) - 'a'];
            }
            currentTrie.isEnd = true;
        }

    }
}
