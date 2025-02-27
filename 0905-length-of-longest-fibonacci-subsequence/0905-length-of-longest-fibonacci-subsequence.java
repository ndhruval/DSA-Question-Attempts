class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n= arr.length;
        int maxLen =0;
        int[][] dp = new int[n][n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int curr =0;curr<n;curr++)
        {
            map.put(arr[curr],curr);
            for(int prev=0;prev<curr;prev++)
            {
                int diff= arr[curr]-arr[prev];
                int prevIdx = map.getOrDefault(diff,-1);

                if(diff<arr[prev] && prevIdx>=0)
                dp[prev][curr]= dp[prevIdx][prev]+1;
                else
                dp[prev][curr]=2;

                maxLen = Math.max(maxLen,dp[prev][curr]);
            }
        }

        return maxLen>2? maxLen:0;

        
    }
}