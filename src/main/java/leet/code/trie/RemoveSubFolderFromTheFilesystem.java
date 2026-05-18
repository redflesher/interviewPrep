// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
package leet.code.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFolderFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();

        for (String item : folder) {
            trie.addElement(item);
        }

        dsf(trie, result, new StringBuilder());

        return result;

    }

    private void dsf(Trie trie, List<String> result, StringBuilder sb) {
        if (trie.isEnd) {
            result.add(sb.toString());
            return;
        }
        for (Map.Entry<String, Trie> child : trie.children.entrySet()) {
            sb.append("/").append(child.getKey());
            dsf(child.getValue(), result, sb);
            sb.delete(sb.length() - child.getKey().length() - 1, sb.length());
        }
    }

    private class Trie {
        private final Map<String, Trie> children;
        private boolean isEnd;

        public Trie() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }

        public void addElement(String element) {
            Trie currentTrie = this;
            String[] splitted = element.split("/");
            for (int i = 1; i < splitted.length; i++) {
                if (!currentTrie.children.containsKey(splitted[i]))
                    currentTrie.children.put(splitted[i], new Trie());
                currentTrie = currentTrie.children.get(splitted[i]);
            }
            currentTrie.isEnd = true;
        }
    }
}
