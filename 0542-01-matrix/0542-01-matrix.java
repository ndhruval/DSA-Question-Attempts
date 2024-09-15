class Node {
    int row, column, dist;
    public Node(int r, int c, int d) {
        this.row = r;
        this.column = c;
        this.dist = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] distance = new int[rows][cols];
        int[][] vis = new int[rows][cols];
        Queue<Node> q = new ArrayDeque<>();
        
        // Initialize the queue with all '0' cells and mark them as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = 1; // Mark '0' cells as visited
                }
            }
        }
        
        int[] delRow = {-1, 0, +1, 0}; // Direction array for row
        int[] delCol = {0, +1, 0, -1}; // Direction array for column

        // BFS traversal
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().column;
            int steps = q.peek().dist;
            q.remove();
            
            // Set the distance for the current cell
            distance[row][col] = steps;
            
            // Check all 4 neighboring cells
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                // Check for valid and unvisited neighboring cell
                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; // Mark as visited
                    q.add(new Node(nrow, ncol, steps + 1)); // Add to queue with incremented distance
                }
            }
        }
        
        // Return the distance matrix
        return distance;
    }
}
