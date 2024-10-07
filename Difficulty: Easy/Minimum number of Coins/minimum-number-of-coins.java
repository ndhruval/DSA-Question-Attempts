//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    static List<Integer> minPartition(int N)
    {
        List<Integer> res = new ArrayList<>();
        int deno[] = {1 ,2,5,10,20,50,100,200,500,2000};
        int f[] = new int[10];
        int x =N;
            if(x/2000 > 0)
            {
                f[9] = x/2000;
                x = x%2000;   
            }
            if(x/500 > 0)
            {
                f[8] = x/500;
                x = x%500;   
            }
            if(x/200 > 0)
            {
                f[7] = x/200;
                x = x%200;   
            }
            if(x/100 > 0)
            {
                f[6] = x/100;
                x = x%100;   
            }
            if(x/50 > 0)
            {
                f[5] = x/50;
                x = x%50;   
            }
            if(x/20 > 0)
            {
                f[4] = x/20;
                x = x%20;   
            }
            if(x/10 > 0)
            {
                f[3] = x/10;
                x = x%10;   
            }
            if(x/5 > 0)
            {
                f[2] = x/5;
                x = x%5;   
            }
            if(x/2 > 0)
            {
                f[1] = x/2;
                x = x%2;   
            }
            f[0] = x;
            
            for(int i =9;i>=0;i--)
            {
                if(f[i]>0)
                {
                    while(f[i]>0)
                    {
                        res.add(deno[i]);
                        f[i]--;
                    }
                }
            }
            return res;
            
            
        
        
        // code here
        
    }
}