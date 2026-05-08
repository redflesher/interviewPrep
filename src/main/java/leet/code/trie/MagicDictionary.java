// https://leetcode.com/problems/implement-magic-dictionary/description/
package leet.code.trie;

public class MagicDictionary {
    private MagicDictionary[] children;
    private boolean isEnd;

    public MagicDictionary() {
        this.children = new MagicDictionary[26];
        this.isEnd = false;
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            MagicDictionary currentMagicDictionary = this;
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                if (currentMagicDictionary.children[index] == null)
                    currentMagicDictionary.children[index] = new MagicDictionary();
                currentMagicDictionary = currentMagicDictionary.children[index];
            }
            currentMagicDictionary.isEnd = true;
        }

    }

    public boolean search(String searchWord) {
        MagicDictionary currentMagicDictionary = this;

        return  dsf(0, false, searchWord, currentMagicDictionary);

    }

    private boolean dsf(
            int index,
            boolean isExtra,
            String searchWord,
            MagicDictionary currentMagicDictionary
    ) {
        if (currentMagicDictionary.isEnd && isExtra && searchWord.length() == index)
            return true;
        if (searchWord.length() - 1 < index)
            return false;

        if (currentMagicDictionary.children[searchWord.charAt(index) - 'a'] != null) {
            if (dsf(index + 1, isExtra, searchWord, currentMagicDictionary.children[searchWord.charAt(index) - 'a']))
                return true;
        }
        if (!isExtra) {
            for (int i = 0; i < currentMagicDictionary.children.length; i++) {
                if (searchWord.charAt(index) - 'a' == i)
                    continue;
                if (currentMagicDictionary.children[i] != null)
                    if (dsf(index + 1, true, searchWord, currentMagicDictionary.children[i]))
                        return true;
            }
        }

        return false;
    }
}
