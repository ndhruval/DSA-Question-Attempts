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
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    static String postToInfix(String exp) {
        Stack<StringBuilder> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(new StringBuilder().append(ch));
            } else {
                StringBuilder s1 = st.pop(); // right
                StringBuilder s2 = st.pop(); // left

                StringBuilder sb = new StringBuilder();
                sb.append('(').append(s2).append(ch).append(s1).append(')');

                st.push(sb);
            }
        }

        return st.pop().toString();
    }
}
