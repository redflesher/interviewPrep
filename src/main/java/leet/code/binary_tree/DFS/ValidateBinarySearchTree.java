// https://leetcode.com/problems/validate-binary-search-tree/description/
package leet.code.binary_tree.DFS;

import leet.code.binary_tree.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return preOrderTraversalHelper(root, min, max);

    }

    private static Boolean preOrderTraversalHelper(TreeNode node, long min, long max) {
        if (node == null)
           return true;

        if (node.val <= min || node.val >= max)
            return false;

        return preOrderTraversalHelper(node.left, min, node.val) &&
                preOrderTraversalHelper(node.right, node.val, max);
    }
}
