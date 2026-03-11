// https://leetcode.com/problems/clone-graph/description/
package leet.code.graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);
    }

    private Node clone(Node node, Map<Node, Node> visited) {
        if (node == null)
            return null;
        if (visited.containsKey(node))
            return visited.get(node);

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node item : node.neighbors) {
            cloneNode.neighbors.add(clone(item, visited));
        }

        return cloneNode;
    }
}
