//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int maximumPoints(int arr[][]) 
    {
        int n= arr.length;
        int dp[][] = new int [n][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1], arr[0][2]));
        
        for(int day = 1;day<= n-1;day++)
        {
            for(int last =0;last<=3;last++)
            {
                dp[day][last] =0;
                for(int task =0; task<=2;task++)
                {
                    if(task != last)
                    {
                        int ac = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], ac);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    
}
// User function Template for Java

