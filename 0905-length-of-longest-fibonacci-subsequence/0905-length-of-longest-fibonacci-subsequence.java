class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n= arr.length;
        int dp[][] = new int[n][n];
        int maxLen=0;
        for(int curr=2;curr<n;curr++)
        {
            int start =0;
            int end = curr-1;

            while(start<end)
            {
                int pair = arr[start]+arr[end];
                if(pair<arr[curr])
                start++;
                else if(pair>arr[curr])
                end--;
                else
                {
                    dp[end][curr]= dp[start][end]+1;
                    maxLen = Math.max(maxLen,dp[end][curr]);
                    end--;
                    start++;

                }
            }
        }

        return maxLen==0?0:maxLen+2;
        
    }
}