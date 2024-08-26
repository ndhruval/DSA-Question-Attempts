class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        
        int first=0,second=1;

        while(n>1) {
            int sum=first+second;
            first=second;
            second=sum;
            n--;
        }

        return second;
    }
}