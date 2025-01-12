class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // If the starting or ending cell has an obstacle, return 0
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // Starting point

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip obstacles
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // Add paths from the top and left cells
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
