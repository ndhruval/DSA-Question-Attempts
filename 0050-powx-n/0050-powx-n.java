class Solution 
{
    public double myPow(double x, int n) 
    {
        if (n == Integer.MIN_VALUE) {
            x = x * x;  
            n = n / 2;  
        }

        if (n == 0) return 1;

        if (n > 0) {
            
            double half = myPow(x, n / 2); 
            if (n % 2 == 0) {
                return half * half;  
            } else {
                return half * half * x;  
            }
        } else { 
            return 1 / myPow(x, -n);
        }
    }
}

