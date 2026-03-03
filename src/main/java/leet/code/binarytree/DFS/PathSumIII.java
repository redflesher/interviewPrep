package leet.code.binarytree.DFS;

import leet.code.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        traversalHelper(root, result, targetSum, currentPath);
        return result;
    }

    private static void traversalHelper(
            TreeNode node,
            List<List<Integer>> result,
            int targetSum,
            List<Integer> currentPath
    ) {
        if (node == null)
            return;
        currentPath.add(node.val);
        if (node.left == null && node.right == null) {
            // leaf
            int sum = currentPath.parallelStream().mapToInt(Integer::intValue).sum();
            if (targetSum == sum)
                result.add(new ArrayList<>(currentPath));
        }

        traversalHelper(node.left, result, targetSum, currentPath);
        traversalHelper(node.right, result, targetSum, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }
}
