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


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        boolean visited[] = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                if(dfs(adj,i,-1,visited)== true)
                return true;
            }
        }
        return false;
        // Code here
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int Node, int Parent, boolean[] visited)
    {
        visited[Node] = true;
        for(Integer it: adj.get(Node))
        {
            if(visited[it]== false)
            {
                if(dfs(adj,it,Node,visited)== true)
                return true;
            }
            else if(it != Parent)
            return true;
        }
        return false;
    }
}