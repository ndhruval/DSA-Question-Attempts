//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V)
    {
        int count =0;
        boolean vis[] = new boolean[V];
        for(int i =0; i<V;i++)
        {
            vis[i] = false;
        }
        for(int i =0;i< V;i++)
        {
            if(!vis[i])
            {
                count++;
            dfs(adj,V, i, vis);
            }
        }
        return count;
        // code here
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int V, int curr, boolean[] vis)
    {
        vis[curr] = true;
        
        for(int i =0; i< V;i++)
        {
            if(adj.get(curr).get(i) == 1 && vis[i] == false)
            dfs(adj, V , i, vis);
        }
    }
};