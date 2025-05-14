//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result += st.pop();
                }
                st.pop(); // pop '('
            } else {
                while (!st.isEmpty() &&
                      (prec(ch) <= prec(st.peek()))) {
                    result += st.pop();
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }

    public static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String expr = "h^m^q^(7-4)";
        System.out.println(infixToPostfix(expr)); // Expected: hm^q^74-^
    }
}
