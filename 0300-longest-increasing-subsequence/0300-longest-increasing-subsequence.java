

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n + 1];
        for(int ind = n-1;ind >=0;ind--){
        for(int prev_ind =ind-1;prev_ind >= -1;prev_ind--){
                int notTake = 0 + dp[ind+1][prev_ind +1];
                int take = 0;
                if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
                take = 1 + dp[ind+1][ind+1];
            }
            dp[ind][prev_ind + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
       
        
    }

}