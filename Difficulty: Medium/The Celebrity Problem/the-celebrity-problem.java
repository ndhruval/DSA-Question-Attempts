//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution 
{
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) 
    { 
        int n = mat.length;
        int top = 0, down = n - 1;
        
        // Step 1: Find the potential celebrity
        while (top < down) {
            if (mat[top][down] == 1) {
                // top knows down, so top cannot be a celebrity
                top += 1;
            } else {
                // top does not know down, so down cannot be a celebrity
                down -= 1;
            }
        }
        
        int candidate = top;
        
        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            
            // Check if candidate knows i or if i does not know candidate
            if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                return -1;
            }
        }
        
        return candidate;
    }
}
