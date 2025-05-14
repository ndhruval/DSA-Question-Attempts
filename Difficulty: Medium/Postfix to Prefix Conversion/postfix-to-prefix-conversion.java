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
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        
        Stack<StringBuilder> st = new Stack<>();
        for(int i =0;i<post_exp.length();i++)
        {
            char ch = post_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                st.push(new StringBuilder().append(ch));
            }
            else
            {
                StringBuilder s1 = st.pop();
                StringBuilder s2 = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(ch).append(s2).append(s1);
                st.push(sb);
            }
        }
        return st.pop().toString();
        // code here
        
    }
}
