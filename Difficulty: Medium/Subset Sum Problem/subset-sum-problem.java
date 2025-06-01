class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // If sum is 0, answer is true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If sum is not 0 and set is empty, answer is false
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Include or exclude the current item
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // Cannot include the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}