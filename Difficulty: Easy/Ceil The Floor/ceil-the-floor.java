//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int res[] = new int[2]; // res[0] = floor, res[1] = ceil
        res[0] = -1; // Default value for floor
        res[1] = -1; 
        Arrays.sort(arr);// Default value for ceil

        int l = 0, u = arr.length - 1;

        // Finding Ceil (Smallest element ≥ x)
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (arr[mid] >= x) { 
                res[1] = arr[mid]; // Store ceil value
                u = mid - 1;       // Move left to find a smaller ceil
            } else {
                l = mid + 1;       // Move right
            }
        }

        l = 0;
        u = arr.length - 1;

        // Finding Floor (Largest element ≤ x)
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (arr[mid] <= x) { 
                res[0] = arr[mid]; // Store floor value
                l = mid + 1;       // Move right to find a larger floor
            } else {
                u = mid - 1;       // Move left
            }
        }

        return res;
    }
}

