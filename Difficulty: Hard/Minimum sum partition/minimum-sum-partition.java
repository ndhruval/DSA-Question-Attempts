//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution 
{

    public int minDifference(int arr[]) 
    {
        int sum = 0;
        int n= arr.length;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];
        }
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int j=0;j<=sum;j++)
        {
            dp[0][j] = false;
        }
        for(int i=0;i<=n;i++)
        {
            dp[i][0] = true;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j =1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        
        int min= Integer.MAX_VALUE;
        for(int i=0;i<= sum/2;i++)
        {
            if(dp[n][i] == true)
            {
                min = Math.min(min, sum- 2*i);
                
            }
        }
        return min;
            
            
        // Your code goes here
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends