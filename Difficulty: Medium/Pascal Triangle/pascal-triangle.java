//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Long> temp;
        long mod = 1000000007;
        arr.add(1L);
        for(int i=1;i<n;i++){
            temp = new ArrayList<>();
            temp.add(1L);
            for(int j=1;j<arr.size();j++){
                temp.add(((arr.get(j-1) + arr.get(j))%mod));
            }
            temp.add(1L);
            arr = new ArrayList<>(temp);
        }
        return arr;

    }
}