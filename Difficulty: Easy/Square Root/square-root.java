//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        
        int l =0, h = n, ans=0;
        while(l<=h)
        {
            int mid = l +(h-l)/2;
            if(mid*mid<=n)
            {
                ans = mid;
                l = mid+1;
            }
            else
            h = mid-1;
        }
        return ans;
        // Your code here
    }
}
