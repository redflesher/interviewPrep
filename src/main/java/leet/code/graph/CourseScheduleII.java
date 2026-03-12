// https://leetcode.com/problems/course-schedule-ii/description/
package leet.code.graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            adjList.get(item[1]).add(item[0]);
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited.contains(i))
                if (dsfHelper(visiting, visited, result, adjList, i))
                    return new int[]{};
        }

        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dsfHelper(Set<Integer> visiting,
                              Set<Integer> visited,
                              List<Integer> result,
                              List<List<Integer>> adjList,
                              int node
    ) {
        visiting.add(node);
        List<Integer> currentNode = adjList.get(node);
        for (Integer neighbour : currentNode) {
            if (visiting.contains(neighbour))
                return true;
            if (!visited.contains(neighbour))
                if (dsfHelper(visiting, visited, result, adjList, neighbour))
                    return true;
        }
        visiting.remove(node);
        visited.add(node);
        result.add(node);

        return false;
    }
}
