class Solution {
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n/2);
        long mod = 1000000007;

        return (int)(pow(5,even)* pow(4,odd)%mod);
        
    }
    public static long pow(long x, long n)
    {
        if(n==0)
        return 1;

        long temp = pow(x,n/2);

        if(n%2 == 0)
        return (temp*temp)%1000000007;
        else
        return (temp*temp*x)%1000000007;
    } 
}