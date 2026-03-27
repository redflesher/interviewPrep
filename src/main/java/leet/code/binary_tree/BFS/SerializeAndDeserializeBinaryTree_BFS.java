// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
package leet.code.binary_tree.BFS;

import leet.code.binary_tree.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree_BFS {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null) {
                result.add(String.valueOf(currentNode.val));
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                else
                    queue.offer(null);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);
                else
                    queue.offer(null);
            } else
                result.add("null");

        }

        return String.join(";", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] nodes = data.split(";");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode result = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(result);
        int index = 1;


        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (!nodes[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                currentNode.left = leftNode;
                queue.offer(leftNode);
            }
            index++;
            if (!nodes[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                currentNode.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }
        return result;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
