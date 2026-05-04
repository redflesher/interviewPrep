// https://leetcode.com/problems/replace-words/description/
package leet.code.trie;

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (String s : dictionary) {
            trie.addWord(s);
        }

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = trie.replace(words[i]);
        }

        return String.join(" ", words);
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

        public String replace(String word) {
            StringBuilder sb = new StringBuilder();
            Trie currentTrie = this;
            for (int i = 0; i < word.length(); i++) {
                if (currentTrie.children[word.charAt(i) - 'a'] != null) {
                    sb.append(word.charAt(i));
                    if (currentTrie.children[word.charAt(i) - 'a'].isEnd)
                        return sb.toString();
                    currentTrie = currentTrie.children[word.charAt(i) - 'a'];
                }
                else
                    return word;
            }
            if (currentTrie.isEnd)
                return sb.toString();
            else
                return word;
        }
    }
}
