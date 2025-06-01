class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int dp[][] = new int[n+1][target+1];
        for(int j =0;j<= target;j++)
        {
            dp[0][j] = 0;
        }
        for(int i =0;i<= n;i++)
        {
            dp[i][0] = 1;
        }
        for(int i =1;i<= n;i++){
            for(int j =0;j<= target;j++){
                if(nums[i-1]<=j)
                dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                else
                dp[i][j] = dp[i-1][j];
                
            }
        }
        return dp[n][target];
    }
}