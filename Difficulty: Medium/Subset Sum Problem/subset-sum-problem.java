//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{

    static Boolean isSubsetSum(int arr[], int W) 
    {
        int n = arr.length;
        Boolean dp[][] = new Boolean[n+1][W+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0)
                dp[i][j] = false;
                if(j==0)
                dp[i][j] = true;
                
            }
        }
         for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                
                if(arr[i-1]<=j)
                dp[i][j] = dp[i-1][j- arr[i-1]] || dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        // code here
        return dp[n][W];
    }
}