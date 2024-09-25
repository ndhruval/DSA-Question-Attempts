//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    static String preToPost(String pre_exp)
    {
        int i =pre_exp.length() -1;
        Stack<String> st = new Stack<>();
        while(i>=0 )
        {
            char C = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(C))
            {
                String ans = String.valueOf(C);
                st.push(ans);
            }
            else
            {
                String t1 = st.pop();
                String t2 = st.pop();
                String temp = t1 + t2 + C;
                st.push(temp);
            }
            i--;
        }
        return st.pop();
    }
}
