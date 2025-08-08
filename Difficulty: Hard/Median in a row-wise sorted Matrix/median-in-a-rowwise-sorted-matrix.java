class Solution {
    public int median(int[][] mat) {
        int R = mat.length;      // rows
        int C = mat[0].length;   // columns
        
        int min = mat[0][0];
        int max = mat[0][C-1];
        
        // find min and max
        for (int i = 0; i < R; i++) {
            min = Math.min(min, mat[i][0]);        // first col of each row
            max = Math.max(max, mat[i][C-1]);      // last col of each row
        }
        
        int req = (R * C) / 2;
        int low = min, high = max;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEqual(mat, R, C, mid);
            
            if (smallEqual <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    
    public static int countSmallEqual(int[][] matrix, int R, int C, int mid) {
        int count = 0;
        for (int i = 0; i < R; i++) {
            // binary search in each row
            int lo = 0, hi = C - 1;
            while (lo <= hi) {
                int m = lo + (hi - lo) / 2;
                if (matrix[i][m] <= mid) lo = m + 1;
                else hi = m - 1;
            }
            count += lo; // lo = number of elements <= mid in this row
        }
        return count;
    }
}
