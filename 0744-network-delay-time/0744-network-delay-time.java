class Pair{
    int vertex;
    int time;
    Pair(int v, int t)
    {
        this.vertex= v;
        this.time = t;
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k,0));

        while(!q.isEmpty())
        {
            Pair element = q.poll();
            int v = element.vertex;
            int t = element.time;

            for(Pair neigh: adj.get(v))
            {
                int vn = neigh.vertex;
                int tn = neigh.time;
                if(t+tn < dist[vn])
                {
                    dist[vn]= t+tn;
                    q.add(new Pair(vn,t+tn));
                }
            }
        }
        int max=0;

        for(int i=1;i<n+1;i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
            return -1;

            max = Math.max(max,dist[i]);


        }
        return max;
        
    }
}