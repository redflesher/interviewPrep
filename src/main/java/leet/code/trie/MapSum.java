// https://leetcode.com/problems/map-sum-pairs/description/
package leet.code.trie;

public class MapSum {

    private MapSum[] children;
    private boolean isEnd;
    private int value;

    public MapSum() {
        this.children = new MapSum[26];
        this.isEnd = false;
        this.value = 0;
    }

    public void insert(String key, int val) {
        MapSum currentMapSum = this;
        for (int i = 0; i < key.length(); i++) {
            if (currentMapSum.children[key.charAt(i) - 'a'] == null)
                currentMapSum.children[key.charAt(i) - 'a'] = new MapSum();
            currentMapSum = currentMapSum.children[key.charAt(i) - 'a'];
        }

        currentMapSum.isEnd = true;
        currentMapSum.value = val;
    }

    public int sum(String prefix) {
        MapSum currentMapSum = this;
        int sum = 0;

        for (int i = 0; i < prefix.length(); i++) {
            if (currentMapSum.children[prefix.charAt(i) - 'a'] != null)
                currentMapSum = currentMapSum.children[prefix.charAt(i) - 'a'];
            else
                return 0;
        }

        sum = dsf(sum, currentMapSum);

        return sum;
    }

    private int dsf(int sum, MapSum currentMapSum) {
        if (currentMapSum.isEnd)
            sum += currentMapSum.value;
        for (int i = 0; i < currentMapSum.children.length; i++) {
            if (currentMapSum.children[i] != null) {
                sum = dsf(sum, currentMapSum.children[i]);
            }
        }
        return sum;
    }
}
