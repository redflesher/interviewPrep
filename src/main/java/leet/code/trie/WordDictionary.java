// https://leetcode.com/problems/design-add-and-search-words-data-structure/
package leet.code.trie;

public class WordDictionary {

    private Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        Trie currentTrie = this.trie;
        for (int i = 0; i < word.length(); i++) {
            if (currentTrie.children[word.charAt(i) - 'a'] == null)
                currentTrie.children[word.charAt(i) - 'a'] = new Trie();
            currentTrie = currentTrie.children[word.charAt(i) - 'a'];
        }
        currentTrie.isEnd = true;

    }

    public boolean search(String word) {
        return searchHelper(word, 0, this.trie);
    }

    private boolean dsf(String word, int index, Trie currentTrie) {
        for (int i = 0; i < currentTrie.children.length; i++) {
            if (currentTrie.children[i] != null)
                if (searchHelper(word, index, currentTrie.children[i]))
                    return true;
        }
        return false;
    }

    private boolean searchHelper(String word, int index, Trie currentTrie) {
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                return dsf(word, i +1, currentTrie);
            } else {
                if (currentTrie.children[word.charAt(i) - 'a'] != null)
                    currentTrie = currentTrie.children[word.charAt(i) - 'a'];
                else
                    return false;
            }
        }
        return currentTrie.isEnd;
    }

    private class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }
}
