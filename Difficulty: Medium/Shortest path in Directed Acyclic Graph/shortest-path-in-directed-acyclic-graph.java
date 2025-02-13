//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Pair {
    int vertex, weight;
    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Solution {

    public int[] shortestPath(int V, int E, int[][] edge) {
        // Step 1: Create adjacency list for the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Fill adjacency list using the given edge list
        for (int i = 0; i < E; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            int w = edge[i][2];
            adj.get(u).add(new Pair(v, w));
        }

        // Step 3: Topological Sort using DFS
        int visited[] = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0)
                dfs(i, visited, stack, adj);
        }

        // Step 4: Initialize distances
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0; // Assuming the source node is 0

        // Step 5: Process nodes in Topological Order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            // Only proceed if the distance to the node is known
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(node)) {
                    int v = neighbor.vertex;
                    int wt = neighbor.weight;

                    // Relaxation step
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Step 6: Replace unreachable distances with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }

    // Helper method for DFS and Topological Sorting
    public static void dfs(int node, int visited[], Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = 1;
        for (Pair neighbor : adj.get(node)) {
            int v = neighbor.vertex;
            if (visited[v] == 0)
                dfs(v, visited, stack, adj);
        }
        stack.push(node);
    }
}
