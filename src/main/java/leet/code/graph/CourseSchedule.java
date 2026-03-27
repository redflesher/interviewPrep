// https://leetcode.com/problems/course-schedule/
package leet.code.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (dfs(visited, visiting, adjacencyList, i))
                return false;
        }

        return true;
    }

    private boolean dfs(Set<Integer> visited, Set<Integer> visiting, List<List<Integer>> prerequisites, int node) {
        visiting.add(node);
        for (Integer neighbour: prerequisites.get(node)) {
            if (visiting.contains(neighbour))
                return true;
            if (!visited.contains(neighbour))
                if (dfs(visited, visiting, prerequisites, neighbour))
                    return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }
}
