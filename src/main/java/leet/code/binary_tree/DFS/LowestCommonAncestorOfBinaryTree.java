// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
package leet.code.binary_tree.DFS;

import leet.code.binary_tree.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    //        3
    //       / \
    //      5   1
    //     / \
    //    6   2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postOrderHelper(root, p, q);
    }

    private TreeNode postOrderHelper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;

        if (node == p || node == q)
            return node;

        TreeNode left = postOrderHelper(node.left, p, q);
        TreeNode right = postOrderHelper(node.right, p, q);


        if (left != null && right != null)
            return node;

        return left != null ? left : right;
    }
}
