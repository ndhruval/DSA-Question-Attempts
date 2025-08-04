class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return lcs(text1, text2, text1.length(), text2.length(),dp);
    }

    private int lcs(String text1, String text2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if(dp[n-1][m-1] != -1) return dp[n-1][m-1];

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return dp[n-1][m-1] = 1 + lcs(text1, text2, n - 1, m - 1,dp);
        } else {
          
            return dp[n-1][m-1] =Math.max(lcs(text1, text2, n - 1, m,dp), lcs(text1, text2, n, m - 1,dp));
        }
    }
}