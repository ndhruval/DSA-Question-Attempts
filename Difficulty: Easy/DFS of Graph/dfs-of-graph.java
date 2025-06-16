class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        boolean vis[] = new boolean[V];
        DepthFirst(0,adj,vis,ans);
        return ans;
        
        // Code here
        
    }
    public void DepthFirst(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> ans){
        vis[node] = true;
        ans.add(node);
        for(Integer it: adj.get(node)){
            if(!vis[it])
            DepthFirst(it,adj, vis, ans);
        }
    }
}