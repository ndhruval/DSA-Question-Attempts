
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[] = new boolean[V];
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(vis[i] == false)
            {
                ArrayList<Integer> list = new ArrayList<>();
                dfs(adj,i,list,vis);
                ans.add(list);
            }
        }
        return ans;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> list, boolean vis[])
    {
        vis[node] = true;
        list.add(node);
        
        for(Integer it: adj.get(node))
        {
            if(vis[it] == false)
            dfs(adj, it, list, vis);
        }
    }
}