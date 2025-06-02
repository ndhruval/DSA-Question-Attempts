// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        int n =  arr.length;
        int sum =0;
        for(int i =0;i<n;i++){
            sum += arr[i];
        }
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int j =0;j<=sum;j++){
            dp[0][j] = false;
        }
        for(int i =0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<=sum/2;j++){
            if(dp[n][j] == true){
                min = Math.min(min, sum- 2*j);
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        return min;
        // Your code goes here
    }
}
