class Solution 
{
    public int findCircleNum(int[][] isConnected) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = isConnected.length;
        for(int i = 0;i<V;i++) 
        {
            adj.add(new ArrayList<Integer>()); 
        }
        for(int i =0;i< isConnected.length;i++)
        {
            for(int j =0;j< isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1 && i != j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }


            }
        }

        boolean vis[] = new boolean[V];
        int count =0;
        for(int i =0;i<V;i++)
        {
            if(vis[i]== false)
            {
                count ++;
                dfs(adj,vis,i);
            }

        }
        return count;
        

        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr)
    {
        vis[curr] = true;
        for(int i =0;i< adj.get(curr).size(); i++)
        {
            int e = adj.get(curr).get(i);
            if(vis[e]== false)
            dfs(adj,vis,e);

        }
    }
}