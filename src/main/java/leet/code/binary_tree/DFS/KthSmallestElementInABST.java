// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
package leet.code.binary_tree.DFS;

import leet.code.binary_tree.TreeNode;

public class KthSmallestElementInABST {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorderTraversalHelper(root, k);
        return result;

    }

    private void inorderTraversalHelper(TreeNode node, int k) {
        if (node == null)
            return;


        inorderTraversalHelper(node.left, k);
        count++;
        if (k == count) {
            result = node.val;
            return;
        }

        inorderTraversalHelper(node.right, k);
    }
}
