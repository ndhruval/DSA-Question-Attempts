import java.util.*;
class element{
    int row,col,min;
    public element( int r, int c, int m)
    {
        this.row = r;
        this.col = c;
        this.min = m;
    }
}

class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        int r = grid.length;
        int c = grid[0].length;
        int fresh =0;
        Queue<element> q = new ArrayDeque<>();
        for(int i =0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1)
                fresh++;
                else if(grid[i][j]==2)
                {
                    q.offer(new element(i,j,0));
                    grid[i][j]=0;
                }
            }
        }
        if(q.isEmpty() && fresh == 0)
        return 0;

        int maxMins =0;
        int rowd[] = {-1,0,+1,0};
        int cold[] = {0,-1,0,+1};

        while(!q.isEmpty())
        {
            element curr = q.poll();
            maxMins = Math.max(maxMins, curr.min);
            for(int i=0;i<4;i++)
            {
                int adjr = curr.row + rowd[i];
                int adjc = curr.col + cold[i];
                if(adjr >=0 && adjr< r && adjc>=0 && adjc<c && grid[adjr][adjc]==1)
                {
                    q.add(new element(adjr, adjc, curr.min +1));
                    fresh --;
                    grid[adjr][adjc] =0;
                }
            }
        }
        if(fresh > 0)
        return -1;
        return maxMins;
        
    }
}