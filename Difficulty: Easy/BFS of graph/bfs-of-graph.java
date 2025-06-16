class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        int vis[] = new int[V];
        q.offer(0);
        vis[0]= 1;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            
            for(Integer it: adj.get(node)){
                if(vis[it] == 0)
                {
                    vis[it] = 1;
                    q.add(it);
                }
            }
            
        }
        return ans;
        // code here
        
    }
}