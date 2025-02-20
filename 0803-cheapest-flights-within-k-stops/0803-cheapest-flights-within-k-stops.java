class Pair{
    int vertex;
    int price;
    Pair(int v, int p)
    {
        this.vertex = v;
        this.price = p;
    }
}
class Tuple{
    int stops, node, distance;
    Tuple(int s, int n, int d)
    {
        this.stops = s;
        this.node = n;
        this.distance = d;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = flights.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());

        }
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] =0;

        while(!q.isEmpty())
        {
            Tuple tup = q.peek();
            int s = tup.stops;
            int nt= tup.node;
            int d = tup.distance;
            q.remove();

            if(s>k)
            continue;

            for(Pair neigh : adj.get(nt))
            {
                int v = neigh.vertex;
                int p = neigh.price;

                if(d+p< dist[v] && s<=k)
                {
                    dist[v]= d+p;
                    q.add(new Tuple(s+1,v,d+p));
                }
            }
        }
        if(dist[dst]== Integer.MAX_VALUE) return -1;
        return dist[dst];

        
    }
}