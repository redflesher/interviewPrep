// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
package leet.code.binary_tree.DFS;

import leet.code.binary_tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_DFS {
    public String serialize (TreeNode root) {
        if (root == null)
            return "null";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize (String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String currentValue = queue.poll();
        if (currentValue.equals("null"))
            return null;
        TreeNode currentNode = new TreeNode(Integer.parseInt(currentValue));
        currentNode.left = buildTree(queue);
        currentNode.right = buildTree(queue);

        return currentNode;
    }
}
