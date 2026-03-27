// https://leetcode.com/problems/accounts-merge/description/
package leet.code.graph.union_find;

import java.util.*;

public class AccountMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailWithID = new HashMap<>();
        Map<String, String> emailsWithName = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int k = 0;

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                emailWithID.put(account.get(i), k++);
                emailsWithName.put(account.get(i), account.get(0));
            }
        }
        int[] parent = new int[k];
        int[] rank = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (List<String> account : accounts) {
            int firstEmailID = emailWithID.get(account.get(1));
            for (int i = 1; i < account.size(); i++) {
                union(parent, rank, firstEmailID, emailWithID.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> resultMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailWithID.entrySet()) {
            String email = entry.getKey();
            int rootID = findRoot(parent, entry.getValue());
            if (!resultMap.containsKey(rootID)) {
                List<String> emails = new ArrayList<>();
                emails.add(email);
                resultMap.put(rootID, emails);
            } else {
                resultMap.get(rootID).add(email);
            }
        }

        for (List<String> emails : resultMap.values()) {
            Collections.sort(emails);
            String name = emailsWithName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            result.add(account);
        }

        return result;
    }

    private static int findRoot(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findRoot(parent, parent[node]);
        }
        return parent[node];
    }

    private static void union(int[] parent, int[] rank, int a, int b) {
        int rootA = findRoot(parent, a);
        int rootB = findRoot(parent, b);
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
