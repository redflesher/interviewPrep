// https://leetcode.com/problems/implement-trie-prefix-tree/description/
package leet.code.trie;

public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null)
                current.children[word.charAt(i) - 'a'] = new Trie();
            current = current.children[word.charAt(i) - 'a'];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        Trie current = traversal(this, word);
        if (current == null)
            return false;
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie current = traversal(this, prefix);
        return current != null;
    }

    private Trie traversal(Trie trie, String word) {
        Trie current = trie;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null)
                return null;
            current = current.children[word.charAt(i) - 'a'];
        }

        return current;
    }
}
