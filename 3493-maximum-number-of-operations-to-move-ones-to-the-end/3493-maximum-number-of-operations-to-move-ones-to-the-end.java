class Solution {
    public int maxOperations(String s) {
        

        char[] c = s.toCharArray();
        
        int n = s.length();
        int x[] = new int[n];
        int g =0;
        for(int i= 0;i<n;i++)
        {
            if(c[i]== '1')
            {
                g++;
                x[i]=g;
            }


        }
        int ans=0;
        for(int i=n-1;i>0;i--)
        {
            if(c[i]=='0' && c[i-1]=='1')
            ans += x[i-1];

        }
        return ans;


        
    }
}