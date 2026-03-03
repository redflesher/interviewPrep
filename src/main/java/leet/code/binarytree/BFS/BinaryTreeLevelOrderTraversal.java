// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
package leet.code.binarytree.BFS;

import leet.code.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) queue.offer(currentNode.left);

                if (currentNode.right != null) queue.offer(currentNode.right);

                currentLevel.add(currentNode.val);

            }

            result.add(currentLevel);
        }
        return result;
    }
}