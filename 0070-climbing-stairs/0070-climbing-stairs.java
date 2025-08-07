class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return function(n,dp);
    }
    public static int function(int n, int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n] != -1) return dp[n];
        
        return dp[n]= function(n-1,dp) + function(n-2,dp);
    }
}