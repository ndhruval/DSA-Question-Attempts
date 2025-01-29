class Pair{
    int row;
    int col;
    int time;

    Pair(int r, int c, int t)
    {
        this.row = r;
        this.col = c;
        this.time = t;
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int total =0;

        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                visited[i][j]= 2;
                q.add(new Pair(i,j,0));
                }
                else
                visited[i][j]=0;

                if(grid[i][j] != 0)
                total++;

            }
        }

        int tm =0;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        

        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.remove();
            tm = Math.max(tm,t);
            for(int i=0;i<4;i++)
            {
                int nrow = r +drow[i];
                int ncol = c +dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0 )
                {
                    visited[nrow][ncol]=2;
                    q.add(new Pair(nrow, ncol, t+1));
                }
            }

            

        }
        int count=0;
            for(int i=0;i<n;i++)
            {
                for(int j =0;j<m;j++)
                {
                    if(visited[i][j]==2)
                    count ++;
                }
            }
            if(count == total)
            return tm;
            else
            return -1;



       

        
    }
}