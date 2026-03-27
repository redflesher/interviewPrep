// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
package leet.code.binary_tree.DFS;

import leet.code.binary_tree.TreeNode;

public class BinaryTreeMaximumPathSum {
    private static int globalMaximum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        globalMaximum = Integer.MIN_VALUE;
        postOrderTraversalHelper(root);
        return globalMaximum;
    }

    private static int postOrderTraversalHelper (TreeNode node) {
        if (node == null)
            return 0;

        int leftTreeSum = Math.max(0, postOrderTraversalHelper(node.left));
        int rightTreeSum = Math.max(0, postOrderTraversalHelper(node.right));

        int localMax = node.val + leftTreeSum + rightTreeSum;
        globalMaximum = Math.max(localMax, globalMaximum);

        return node.val + Math.max(leftTreeSum, rightTreeSum);
    }
}
