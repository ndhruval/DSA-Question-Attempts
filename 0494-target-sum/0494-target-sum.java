class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        int n = nums.length;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        // Check for invalid cases
        if ((target + total) % 2 != 0 || target > total || target < -total) {
            return 0;
        }

        int sum = (target + total) / 2;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize DP array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // One way to achieve a sum of 0
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}