class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int initialColor = grid[sr][sc];
        if (initialColor != newColor) {
            fill(grid, sr, sc, initialColor, newColor);
        }
        return grid;
    }

    private void fill(int[][] grid, int sr, int sc, int initialColor, int newColor) {
        if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] != initialColor) {
            return;
        }
        
        grid[sr][sc] = newColor;

        fill(grid, sr + 1, sc, initialColor, newColor);
        fill(grid, sr - 1, sc, initialColor, newColor);
        fill(grid, sr, sc + 1, initialColor, newColor);
        fill(grid, sr, sc - 1, initialColor, newColor);
    }
}
