// https://leetcode.com/problems/implement-trie-prefix-tree/description/
package leet.code.trie;

public class Trie_ {

    private Trie_[] children;
    private boolean isEnd;

    public Trie_() {
        this.children = new Trie_[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie_ current = this;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null)
                current.children[word.charAt(i) - 'a'] = new Trie_();
            current = current.children[word.charAt(i) - 'a'];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        Trie_ current = traversal(this, word);
        if (current == null)
            return false;
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie_ current = traversal(this, prefix);
        return current != null;
    }

    private Trie_ traversal(Trie_ trie, String word) {
        Trie_ current = trie;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null)
                return null;
            current = current.children[word.charAt(i) - 'a'];
        }

        return current;
    }
}
