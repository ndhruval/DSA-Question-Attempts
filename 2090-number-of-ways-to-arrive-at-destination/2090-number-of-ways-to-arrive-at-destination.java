class Solution {
    public int countPaths(int n, int[][] roads) {
        final long INF = Long.MAX_VALUE / 2;
        final int MOD = (int) 1e9 + 7;

        // Step 1: Initialize adjacency matrix with INF
        long[][] graph = new long[n][n];
        for (long[] row : graph) {
            Arrays.fill(row, INF);
        }

        // Step 2: Fill the adjacency matrix with given roads
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph[u][v] = time;
            graph[v][u] = time;
        }

        // Step 3: Dijkstra’s Algorithm
        long[] dist = new long[n]; // Shortest time to each node
        Arrays.fill(dist, INF);
        dist[0] = 0;

        int[] ways = new int[n]; // Number of shortest paths
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0)); // Start from node 0 with time 0

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long time = curr.time;

            // If we’ve already found a shorter way, skip
            if (time > dist[u]) continue;

            // Step 4: Explore neighbors in the matrix
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == INF) continue; // No direct edge

                long newTime = time + graph[u][v];

                if (newTime < dist[v]) { // Found a shorter path
                    dist[v] = newTime;
                    ways[v] = ways[u]; // Inherit path count
                    pq.offer(new Pair(v, newTime));
                } else if (newTime == dist[v]) { // Found another shortest path
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1]; // Number of ways to reach node (n-1)
    }

    // Pair class for Priority Queue
    static class Pair implements Comparable<Pair> {
        int node;
        long time;
        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair other) {
            return Long.compare(this.time, other.time);
        }
    }
}