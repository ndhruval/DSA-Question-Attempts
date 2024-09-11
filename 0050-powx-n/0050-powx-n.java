class Solution 
{
    public double myPow(double x, int n) 
    {
        // Handle the edge case for Integer.MIN_VALUE
        if (n == Integer.MIN_VALUE) {
            x = x * x;  // Multiply x by itself
            n = n / 2;  // Halve n to prevent overflow
        }

        // Base case: any number raised to the power of 0 is 1
        if (n == 0) return 1;

        if (n > 0) {
            // If n is positive, optimize by squaring
            double half = myPow(x, n / 2);  // Recursive call with n / 2
            if (n % 2 == 0) {
                return half * half;  // If n is even
            } else {
                return half * half * x;  // If n is odd
            }
        } else {
            // For negative n, invert x and change n to positive
            return 1 / myPow(x, -n);
        }
    }
}

