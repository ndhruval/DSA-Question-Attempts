//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution 
{
    public static int rotateDelete(ArrayList<Integer> arr) 
    {
        int sz = arr.size();
        int n =sz;
        int k = sz/2;
        if(sz == 1)
        return arr.get(0);
        
        for(int i =1;i<=k;i++)
        {
            int x = arr.get(n-1);
            arr.remove(n-1);
            arr.add(0,x);
            int y = n-i+1;
            
            arr.remove(y-1);
            n--;
        }
        int u = arr.get(0);
        return u;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends