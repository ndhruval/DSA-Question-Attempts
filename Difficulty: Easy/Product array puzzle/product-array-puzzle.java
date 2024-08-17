//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public static long[] productExceptSelf(int nums[]) 
    {
        long result[] = new long[nums.length];
        result[0]=1;
        
        for(int i =1;i<nums.length;i++)
        {
            result[i] = result[i-1]* nums[i-1];
            
        }
        long rightproduct =1;
        
        for(int i=nums.length-1;i>=0;i--)
        {
            
            result[i]= result[i]* rightproduct;
            rightproduct *= nums[i];
        }
        return result;
    }
}
