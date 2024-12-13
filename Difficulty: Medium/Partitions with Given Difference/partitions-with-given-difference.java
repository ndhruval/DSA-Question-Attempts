//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        // Check for invalid cases
        if ((sum - d) < 0 || (sum - d) % 2 != 0) {
            return 0;
        }
        
        int target = (sum - d) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one subset (empty subset) with sum 0
        
        // Fill dp array
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
}
