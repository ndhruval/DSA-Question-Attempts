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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        
        Stack<StringBuilder> st = new Stack<>();
        for(int i =pre_exp.length()-1;i>=0;i--)
        {
            char ch = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                st.push(new StringBuilder().append(ch));
            }
            else
            {
                StringBuilder s1 = st.pop();
                StringBuilder s2 = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append('(').append(s1).append(ch).append(s2).append(')');
                st.push(sb);
            } 
        }
        return st.pop().toString();
        // code here
        
    }
}
