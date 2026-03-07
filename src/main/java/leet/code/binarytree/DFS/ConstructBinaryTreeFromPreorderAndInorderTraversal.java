// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
package leet.code.binarytree.DFS;

import leet.code.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);

    }
    private static TreeNode build(int[] preorder,
                           int[] inorder,
                           int preorderStart,
                           int preorderEnd,
                           int inorderStart,
                           int inorderEnd,
                           Map<Integer, Integer> inorderMap) {

        if (preorderStart > preorderEnd)
            return null;
        int currentRoot = preorder[preorderStart];
        int currentRootIndex = inorderMap.get(currentRoot);
        int leftSubtreeSize = currentRootIndex - inorderStart;

        // recurse left
        TreeNode left = build(preorder,
                inorder,
                preorderStart + 1,
                preorderStart + leftSubtreeSize,
                inorderStart,
                currentRootIndex - 1,
                inorderMap);
        // recurse right
        TreeNode right = build(preorder,
                inorder,
                preorderStart + leftSubtreeSize + 1,
                preorderEnd,
                currentRootIndex + 1,
                inorderEnd,
                inorderMap);

        return new TreeNode(currentRoot, left, right);
    }

}
