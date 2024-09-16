//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }

            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(nums));
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        int n=arr.size();
        int sum=0;
        int max=Integer.MIN_VALUE,i=0,j=1;

        while(j<n && i<n-1){ 
             sum=arr.get(i)+arr.get(j);
             max=Math.max(sum,max);

             sum =0;                                

             j++;
             i++;
         }
        return max;

    }
}