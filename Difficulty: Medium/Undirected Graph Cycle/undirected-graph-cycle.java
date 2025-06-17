class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i =0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        int vis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(list,i,-1,vis)== true)
                return true;
            }
        }
        return false;
        // Code here
        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, int[] vis){
        vis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it] != 1){
               if(dfs(adj,it, node,vis)== true) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
}