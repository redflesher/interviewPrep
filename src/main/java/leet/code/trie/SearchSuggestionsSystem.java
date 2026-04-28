// https://leetcode.com/problems/search-suggestions-system/description/
package leet.code.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    /*public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        int left = 0;
        int right = products.length - 1;
        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> currentResult = new ArrayList<>();
            char c = searchWord.charAt(i);
            while (left <= right &&
                    (products[left].length() == i || products[left].charAt(i) < c)) {
                left++;
            }
            while (left <= right &&
                    (products[right].length() == i || products[right].charAt(i) > c)) {
                right--;
            }

            for (int j = 0; j < 3 && left + j <= right; j++) {
                currentResult.add(products[left+j]);
            }
            result.add(currentResult);
        }

        return result;
    }*/
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();

        for (String product : products) {
            trie.insert(product);
        }

        Trie currentTrie = trie;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> currentList = new ArrayList<>();
            currentTrie = currentTrie.children[searchWord.charAt(i) - 'a'];
            if (currentTrie == null) {
                result.add(currentList);
                continue;
            }
            sb.append(searchWord.charAt(i));
            dfs(currentTrie, sb, currentList);
            result.add(currentList);
        }

        return result;
    }

    private void dfs(Trie currentTrie,
                     StringBuilder currentPrefix,
                     List<String> currentList
    ) {
        if (currentTrie == null)
            return;
        if (currentTrie.isEnd && currentList.size() < 3)
            currentList.add(currentPrefix.toString());
        if (currentList.size() == 3)
            return;

        for (int i = 0; i < currentTrie.children.length; i++) {
            if (currentTrie.children[i] != null) {
                currentPrefix.appendCodePoint(i + 'a');
                dfs(currentTrie.children[i], currentPrefix, currentList);
                currentPrefix.deleteCharAt(currentPrefix.length() - 1);
            }

        }

    }

    static class Trie {
        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie current = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null)
                    current.children[index] = new Trie();
                current = current.children[index];
            }
            current.isEnd = true;
        }

        public Trie search(String word) {
            Trie current = this;
            for (int i = 0; i < word.length(); i++) {
                if (current.children[word.charAt(i) - 'a'] == null)
                    return null;
                current = current.children[word.charAt(i) - 'a'];
            }
            return current;
        }
    }

}
