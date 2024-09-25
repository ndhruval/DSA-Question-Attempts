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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
     static String postToInfix(String exp) 
    {
        int i=0;
        Stack<String> st = new Stack<>();
        while(i<exp.length())
        {
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)) 
            {
                String ans = String.valueOf(c);
                st.push(ans);
            }
            else
            {
                String t1 = st.pop();
                String t2 = st.pop();
                String con = '(' + t2 + c + t1 + ')';
                st.push(con);
            }
            i++;
        }
        return st.pop();
        // code here
    }
}
