class Solution {
    static int matrixMultiplication(int arr[]) {
        int dp[][] = new int[arr.length+1][arr.length+1];
        for(int i=0;i<= arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans= solve(arr,1,arr.length-1,dp);
        return ans;
        
    }
    static int solve(int arr[], int i, int j, int dp[][]){
        if(i>=j)
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k =i;k<j;k++){
            int temp = solve(arr,i,k,dp)+ solve(arr,k+1,j,dp)+ (arr[i-1]*arr[k]*arr[j]);
            min = Math.min(min, temp);
        }
        return dp[i][j]=min;
    }
}