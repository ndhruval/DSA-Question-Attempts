class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        return function(arr,1,n-1,min, dp);
        // code here
        
    }
    public static int function(int arr[], int i, int j, int min, int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        for(int k =i;k< j;k++){
            int ans = function(arr,i ,k,min, dp) + function(arr, k+1, j, min, dp
            ) 
            + arr[i-1]*arr[k]*arr[j];
            min = Math.min(ans, min);
        }
        return dp[i][j] = min;
        
    }
}