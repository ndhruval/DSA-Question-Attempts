class Solution {
    private void dfs(int node, int[][] adjmatrix, int v, boolean[] visited){
        // perform dfs on one connected component
        visited[node] = true;
        for (int i = 0; i < v; i++){
            if (adjmatrix[node][i] == 1 && !visited[i]){
                dfs(i, adjmatrix, v, visited);
            }
        }
    }
    public int findCircleNum(int[][] adjmatrix) {
        int v = adjmatrix.length;
        boolean[] visited = new boolean[v];
        int num_provinces = 0;
        for (int i = 0; i < v; i++){
            if (!visited[i]){
                num_provinces++;
                dfs(i, adjmatrix, v, visited);
            }
        }
        return num_provinces;
    }
}