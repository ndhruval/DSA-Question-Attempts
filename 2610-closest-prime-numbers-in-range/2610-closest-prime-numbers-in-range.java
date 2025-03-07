import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] res = {-1, -1};  
        int last = -1;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (last != -1) {  
                    int diff = i - last;
                    if (diff < minDiff) {
                        minDiff = diff;
                        res[0] = last;
                        res[1] = i;
                    }
                }
                last = i;  
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true; 
        if (n % 2 == 0) return false;  
        
        for (int i = 3; i * i <= n; i += 2) { 
            if (n % i == 0) return false;
        }
        return true;
    }
}
