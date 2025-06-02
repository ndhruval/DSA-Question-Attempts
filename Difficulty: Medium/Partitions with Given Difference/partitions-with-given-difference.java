
class Solution {
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int sum =0;
        for(int i =0;i<n;i++){
            sum += arr[i];
        }
        if ((sum + d) % 2 != 0 || (sum + d) / 2 < 0) return 0;
        sum = (sum+d)/2;
        int dp[][] = new int[n+1][sum+1];
        for(int j = 0;j<=sum;j++){
            dp[0][j] = 0;
        }
        for(int i =0;i<= n;i++){
            dp[i][0] = 1;
        }
        for(int i =1;i<= n;i++){
            for(int j=0;j<= sum;j++){
                if(arr[i-1]<= j)
                dp[i][j] = dp[i-1][j] + dp[i-1][j- arr[i-1]];
                else
                dp[i][j] = dp[i-1][j];
            }
            
        }
        
        return dp[n][sum];
        // code here
        
    }
}
