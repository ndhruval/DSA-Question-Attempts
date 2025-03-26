import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] nums = new int[size];
        int k = 0;

        // Flatten the grid and check divisibility
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((grid[i][j] - grid[0][0]) % x != 0) {
                    return -1; // Not possible if not all elements can be made equal with steps of x
                }
                nums[k++] = grid[i][j];
            }
        }

        // Sort the flattened array
        Arrays.sort(nums);
        int median = nums[size / 2]; // Correct way to find the median

        // Calculate the minimum operations
        int minOps = 0;
        for (int num : nums) {
            minOps += Math.abs(num - median) / x;
        }

        return minOps;
    }
}
