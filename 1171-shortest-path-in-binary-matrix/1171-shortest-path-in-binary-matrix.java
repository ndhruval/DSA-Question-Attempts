class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid== null || grid.length==0 || grid[0].length==0)
        return -1;
        int ans=0;
        int n= grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1]==1)
        return -1;

        int drow[] ={-1,-1,0,+1,+1,+1,0,-1};
        int dcol[] ={0,+1,+1,+1,0,-1,-1,-1};

        int visited[][] = new int [n][n];

        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0]=1;

        while(!q.isEmpty())
        {
            int size = q.size();
            ans++;

            for(int i=0;i<size;i++)
            {
                int[] cur= q.poll();
                if(cur[0]==n-1 && cur[1]==n-1)
                return ans;

                for(int j=0;j<8;j++)
                {
                    int x= cur[0] + drow[j];
                    int y = cur[1] + dcol[j];

                    if(x<0 || x>=n || y<0|| y>=n || visited[x][y]==1|| grid[x][y]==1)
                    continue;

                    visited[x][y]=1;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return -1;

        
    }
}

