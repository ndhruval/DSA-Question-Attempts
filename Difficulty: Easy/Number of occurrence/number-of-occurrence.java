//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) return 0;  // Target not found, frequency is 0
        int last = findLast(arr, target);
        return last - first + 1;
    }

    private int findFirst(int[] arr, int target) {
        int l = 0, u = arr.length - 1, index = -1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) index = mid;
                u = mid - 1;  // Move left to find the first occurrence
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    private int findLast(int[] arr, int target) {
        int l = 0, u = arr.length - 1, index = -1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) index = mid;
                l = mid + 1;  // Move right to find the last occurrence
            } else {
                u = mid - 1;
            }
        }
        return index;
    }
}

