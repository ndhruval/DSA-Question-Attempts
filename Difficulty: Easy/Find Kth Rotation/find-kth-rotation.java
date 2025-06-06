//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> nums) {
         int l = 0, h = nums.size() - 1;

        if (nums.get(l) <= nums.get(h)) return l;

        while (l < h) {
            int mid = l + (h - l) / 2;

            if (nums.get(mid) > nums.get(h)) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l; 
        // Code here
    }
}