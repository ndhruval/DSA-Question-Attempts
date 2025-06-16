class Solution {
    public int findCircleNum(int[][] isConnected) 
    {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j] == 1 && i!= j)
                {
                    adj.get(i).add(j);
                }
            }
        }

        boolean visited[] = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count ++;
                bfs(adj, visited,i);
            }
        }
        return count;


        
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        visited[start]= true;
        while(!q.isEmpty())
        {
            Integer node = q.poll();
            for(Integer it : adj.get(node))
            {
                if(visited[it]== false)
                {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return;
    }
}