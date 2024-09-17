//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    static List<Integer> nextPermutation(int N, int nums[]) {
        int ind = -1;
        int n = nums.length;
        
        // Step 1: Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no such element is found, reverse the entire array
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return convertArrayToList(nums);
        }

        // Step 2: Find the element just larger than nums[ind] and swap
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        // Step 3: Reverse the subarray to get the next permutation
        reverse(nums, ind + 1, n - 1);
        
        return convertArrayToList(nums);
    }

    // Reverse the array between the given start and end indices
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Utility function to convert int[] to List<Integer>
    public static List<Integer> convertArrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}

