//{ Driver Code Starts
//Initial Template for Java

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
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int[] replaceWithRank(int arr[], int N) 
    {
        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank =1;
        for(int i=0;i<sortedArr.length;i++)
        {
            if(!map.containsKey(sortedArr[i]))
            map.put(sortedArr[i], rank++);
        }
        for(int i=0;i<arr.length;i++)
        {
            int x = map.get(arr[i]);
            arr[i]=x;
        }
        return arr;
        
     // code here

  }
}
     