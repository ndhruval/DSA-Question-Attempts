//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            // calling trappingWater() function
            System.out.println(obj.trappingWater(arr));
        }
    }
}

// } Driver Code Ends


class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int height[]) 
    {
        int prefix[] = new int[height.length];
        int suffix[] = new int[height.length];
        long sum =0;

        prefix[0] = height[0];
        suffix[height.length -1] = height[height.length -1];

        for(int i =1;i< height.length;i++)
        {
            prefix[i] = Math.max(height[i], prefix[i-1]);  
        }
        for(int i= height.length -2;i>=0;i--)
        {
            suffix[i] = Math.max(height[i],suffix[i+1]);
        }

        for(int i=0;i< height.length;i++)
        {
            int x = Math.min(prefix[i], suffix[i]) - height[i];
            sum += (long)x;
        }
        return sum;
        
        // Your code here
    }
}
