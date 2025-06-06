class Solution 
{
    public int findLength(int[] nums1, int[] nums2) 
    {
        int m = nums1.length;
        int n = nums2.length;
        int maxLength = 0;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j =0;j<=n;j++)
            {
                if(i==0 || j==0)
                dp[i][j]=0;
            }
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(nums1[i-1]== nums2[j-1])
                {
                dp[i][j] = dp[i-1][j-1] +1;
                maxLength = Math.max(maxLength, dp[i][j]);
                }
                else
                dp[i][j]=0;
            }
        }
        return maxLength;
        
    }
}