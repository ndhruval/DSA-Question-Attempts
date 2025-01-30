//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int parent;
    
    Pair(int n, int p)
    {
        this.node = n;
        this.parent = p;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]== false)
            {
                if(check(adj,visited,V,i))
                return true;
            }
        }
        return false;
        
        // Code here
    }
    
    public boolean check(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int V, int i)
    {
        
        visited[i]= true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,-1));
        
        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            
            for(int sd : adj.get(node))
            {
                if(visited[sd]== false)
                {
                    visited[sd] = true;
                    q.add(new Pair(sd, node));
                }
                else if(parent != sd)
                return true;
            }
        }
        return false;
        
    }
}