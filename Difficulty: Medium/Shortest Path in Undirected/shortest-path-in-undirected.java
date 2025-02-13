//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        
        int n=adj.size();
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            for(int it: adj.get(node))
            {
                if(dist[node]+1 < dist[it])
                {
                dist[it]= dist[node]+1;
                q.add(it);
                }
                
            }
        }
        for(int i=0;i<n;i++)
        {
            if(dist[i]== Integer.MAX_VALUE)
            dist[i]=-1;
        }
        return dist;
        
        // code here
    }
}
