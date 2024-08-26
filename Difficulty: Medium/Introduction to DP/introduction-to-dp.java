//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{

    // Top-down approach (Memoization)
    static long topDown(int n) {
        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        long x = f(n, dp);
        return x % 1000000007;
    }

    static long f(int n, long[] dp) {
        if (n <= 1)
            return (long) n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = (f(n - 1, dp) + f(n - 2, dp)) % 1000000007;
    }

    // Bottom-up approach (Iterative)
    static long bottomUp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            long x = (prev + prev2) % 1000000007;
            prev2 = prev;
            prev = x;
        }
        return prev;
    }
}