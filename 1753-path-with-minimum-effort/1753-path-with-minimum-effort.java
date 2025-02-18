class Solution {
    public int minimumEffortPath(int[][] height) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((x,y)-> x.distance - y.distance);
        int n= height.length;
        int m= height[0].length;

        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] =0;
        pq.add(new tuple(0,0,0));
        int dr[] ={-1,0,1,0};
        int dc[] ={0,1,0,-1};

        while(!pq.isEmpty())
        {
            tuple node = pq.poll();
            int d = node.distance;
            int r = node.row;
            int c = node.col;

            if(r==n-1 && c== m-1)
            return d;

            for(int i=0;i<4;i++)
            {
                int newr = r+ dr[i];
                int newc = c+ dc[i];

                if(newr>=0 && newc>=0 && newr<n && newc<m)
                {
                    int newEffort = Math.max(Math.abs(height[r][c]- height[newr][newc]),d);

                    if(newEffort<dist[newr][newc])
                    {
                        dist[newr][newc] = newEffort;
                        pq.add(new tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        return 0;
        
    }
}

class tuple{
    int distance, row,col;
    tuple(int dist, int r, int c)
    {
        this.distance = dist;
        this.row = r;
        this.col = c;
    }
}