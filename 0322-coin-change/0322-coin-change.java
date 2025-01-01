class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) dp[i][0] = 0; // 0 coins needed to make amount 0
        for (int j = 1; j <= amount; j++) dp[0][j] = Integer.MAX_VALUE; // Impossible without coins

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    // Include the coin only if the sub-problem is solvable
                    if (dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j]; // Exclude the coin
                }
            }
        }

        // Final result
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}
