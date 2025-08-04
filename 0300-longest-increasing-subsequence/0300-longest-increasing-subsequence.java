

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // The DP table must be 2D to store results for each (index, prev_index) pair.
        // We use n+1 for the second dimension to handle the initial prev_index = -1 case.
        int[][] dp = new int[n][n + 1];
        
        // Fill with -1 to indicate that the state has not been computed yet.
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Initial call: index starts at 0, previous_index is -1.
        return function(nums, 0, -1, dp);
    }

    // The 'static' keyword is removed to allow access to instance methods if needed,
    // though not strictly necessary here.
    public int function(int[] nums, int ind, int prev_ind, int[][] dp) {
        // Base case: we've considered all elements.
        if (ind == nums.length) {
            return 0;
        }

        // Use prev_ind + 1 for the DP table to handle the -1 case.
        if (dp[ind][prev_ind + 1] != -1) {
            return dp[ind][prev_ind + 1];
        }

        // Option 1: Don't include the current element nums[ind].
        // The LIS length is whatever we find in the rest of the array.
        int notTake = 0 + function(nums, ind + 1, prev_ind, dp);
        
        int take = 0;
        // Option 2: Include the current element nums[ind].
        // This is only possible if it's the first element (prev_ind == -1)
        // or if it's greater than the previous element chosen.
        if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            // The length is 1 (for this element) + LIS from the rest of the array.
            // The new 'previous index' becomes the current index 'ind'.
            take = 1 + function(nums, ind + 1, ind, dp);
        }
        
        // Store the maximum of the two options in the DP table before returning.
        return dp[ind][prev_ind + 1] = Math.max(take, notTake);
    }
}