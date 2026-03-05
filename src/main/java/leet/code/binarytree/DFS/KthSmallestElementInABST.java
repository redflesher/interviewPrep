// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
package leet.code.binarytree.DFS;

import leet.code.binarytree.TreeNode;

public class KthSmallestElementInABST {
    private static int count;
    private static int result;
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorderTraversalHelper(root, k);
        return result;

    }

    private static void inorderTraversalHelper(TreeNode node, int k) {
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
