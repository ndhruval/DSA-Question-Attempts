//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


class Pair {
    int node, distance;
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] vis = new boolean[V];  // To keep track of visited nodes
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        
        // Start with node 0 (or any node)
        pq.add(new Pair(0, 0));
        int sum = 0;
        int edgesUsed = 0;
        
        while (!pq.isEmpty() && edgesUsed < V) {
            Pair curr = pq.poll();
            int node = curr.node;
            int dist = curr.distance;

            // If already visited, skip
            if (vis[node]) continue;
            
            // Mark as visited
            vis[node] = true;
            sum += dist;
            edgesUsed++;

            // Add all its adjacent nodes to PQ
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int adjDist = neighbor[1];

                if (!vis[adjNode]) {
                    pq.add(new Pair(adjNode, adjDist));
                }
            }
        }
        
        return sum;
    }
}
