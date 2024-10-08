//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
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
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Node {
    int child;
    int parent;
    public Node(int first, int second) {
        this.child = first;
        this.parent = second; 
    }
}
class Solution 
{
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        for(int i=0;i<V;i++)
        {
            if(vis[i]== false)
            {
                if(detection(adj,vis,i) == true)
                return true;
            }
        }
        return false;// Code here
    }
    public boolean detection(ArrayList<ArrayList<Integer>> adj, boolean vis[], int node)
    {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(node,-1));
        vis[node]= true;
        while(!q.isEmpty())
        {
            int n = q.peek().child;
            int par = q.peek().parent;
            
            q.poll();
            for(int neighbor : adj.get(n)) 
            {
                if(!vis[neighbor]) // If the adjacent node is not visited
                {
                    q.offer(new Node(neighbor, n)); // Add it to the queue
                    vis[neighbor] = true;
                } 
                else if(par != neighbor) // If visited and not the parent, cycle found
                {
                    return true;
                }
            }
        }
        return false;
    }
}