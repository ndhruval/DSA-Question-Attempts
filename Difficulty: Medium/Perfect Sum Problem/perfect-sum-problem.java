//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


class Solution 
{
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) 
    {
        int n = nums.length;
        int dp[][] = new int[n + 1][target + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There is one subset (empty subset) with sum 0 for any i
        }
        for (int j = 1; j <= target; j++) {
            dp[0][j] = 0; // There are no subsets with non-zero sum when no elements are considered
        }

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) { // Include j = 0 in the loop
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}
