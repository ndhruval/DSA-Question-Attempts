class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];
        for(int i =0;i<= n;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        int x = Knap(W,val, wt,n,dp);
        return x;
        
        // code here
        
    }
    static int Knap(int W, int val[], int wt[], int n, int[][] dp){
        if(n==0 || W ==0)
        return 0;
        
        if(dp[n][W] != -1)
        return dp[n][W];
        if(wt[n-1]<= W)
        return dp[n][W] = Math.max(val[n-1] + Knap(W - wt[n-1],val, wt, n-1, dp), Knap(W, val, wt, n-1, dp));
        else 
        return dp[n][W] = Knap(W,val, wt,n-1,dp);
    }
}
