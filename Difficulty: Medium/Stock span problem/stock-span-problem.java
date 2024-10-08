//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution 
{
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) 
    {
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = 1;
        
        for(int i =1;i<n;i++)
        {
            while(!st.isEmpty() && price[st.peek()]<= price[i])
            st.pop();
            
            if(st.isEmpty())
            res[i] = i+1;
            else
            res[i] = i - st.peek();
            
            st.push(i);
        }
        return res;
        
        // Your code here
    }
}

//{ Driver Code Starts.

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }
}
// } Driver Code Ends