import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (isCompleteComponent(graph, visited, i)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isCompleteComponent(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> component = new HashSet<>();
        int edgeCount = 0;

        q.add(start);
        visited[start] = true;
        component.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph.get(node)) {
                edgeCount++;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                    component.add(neighbor);
                }
            }
        }

        int k = component.size();
        return edgeCount / 2 == (k * (k - 1)) / 2;  // Check if it forms a clique
    }
}
