//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        String temp = "";
        String ans = "";
        s = s.trim();  // Remove leading and trailing spaces

        int l = s.length();

        for (int i = l - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != '.') {
                temp = ch + temp;
            } else {
                // Add word to the answer only if temp is not empty
                if (!temp.equals("")) {
                    if (!ans.equals("")) {
                        ans = ans + "." + temp;
                    } else {
                        ans = temp;
                    }
                    temp = "";  // Reset temp for the next word
                }
            }
        }

        // Add the last word if there's any left in temp
        if (!temp.equals("")) {
            if (!ans.equals("")) {
                ans = ans + "." + temp;
            } else {
                ans = temp;
            }
        }

        return ans;
    }
    
}