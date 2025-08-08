class Solution
{
    public String longestPalindrome(String s) {
        int n = s.length();
        if(s.length() <0 || s == null)
        return s;
        if(s.length() == 1) return s;
        String dp[][] = new String[n][n];
        return function(0,n-1,s,dp);  
    }
    public static String function(int i, int j,String s, String dp[][]){
        //if(s.length() <0 || s == null)
        //return s;
        //if(s.length == 1) return s;
        if(i>j) return "";
        if(i == j) return s.substring(i, i+1);
        if(dp[i][j] != null) return dp[i][j];
        if(isPalindrome(s.substring(i,j+1)) == true)
        return dp[i][j] = s.substring(i,j+1);

        String palindrome1 = function(i+1,j,s,dp);
        String palindrome2 = function(i,j-1,s,dp);

        return dp[i][j] = palindrome1.length() > palindrome2.length()? palindrome1: palindrome2;

    }
    public static boolean isPalindrome(String s){
        int n = s.length();
        int left =0, right = n-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}