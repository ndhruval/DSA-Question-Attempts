class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n=  coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int i =0;i<=n;i++){
            dp[i][0] = 0; //0 coins are required to get the amount 0
        }
        for(int j =0;j<= amount;j++){
            dp[0][j] = Integer.MAX_VALUE; //INFINTE coins are needed with the value 0 to get the sums more the 0
        }
        for(int j =1;j<= amount;j++){
            dp[1][j] =j%coins[0] == 0? j/coins[0] : Integer.MAX_VALUE -1;
        }
        for(int i =2;i<=n;i++){
            for(int j= 1;j<= amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
                }
                else
                dp[i][j] = dp[i-1][j];

            }
            
        }
        if(dp[n][amount] == Integer.MAX_VALUE -1) return -1;
        return dp[n][amount];
        
    }
}