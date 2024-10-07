//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution 
{

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) 
    {
        int x=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i< n-1;i++)
        {
            set.add(arr[i]);
        }
        for(int i =1;i<=n;i++)
        {
            if(!set.contains(i))
            {
                x=i;
                break;
            }
        }
        return x;

        // Your Code Here
    }
}