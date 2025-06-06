// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // dp[i][j] will store the length of the longest common suffix of s1[0...i-1] and s2[0...j-1]
        int dp[][] = new int[n+1][m+1];
        
        int maxLength = 0;  // To store the length of the longest common substring found
        
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // If characters match, extend the previous substring
                    maxLength = Math.max(maxLength, dp[i][j]);  // Update the maximum length
                } else {
                    dp[i][j] = 0;  // Reset if characters don't match
                }
            }
        }
        
        return maxLength;  // Return the length of the longest common substring
    }
}
