// https://leetcode.com/problems/binary-tree-right-side-view/description/
package leet.code.binary_tree.BFS;

import leet.code.binary_tree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);

                stack.push(currentNode.val);
            }
            result.add(stack.pop());
        }

        return result;
    }

}
