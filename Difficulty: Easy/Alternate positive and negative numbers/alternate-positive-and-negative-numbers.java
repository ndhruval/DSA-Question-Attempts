//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    void rearrange(ArrayList<Integer> arr) 
    {
        List<Integer> posArr = new ArrayList<>();
        List<Integer> negArr = new ArrayList<>();
        for(int nums:arr){
            if(nums<0) negArr.add(nums);
            else posArr.add(nums);
        }
        List<Integer> res = new ArrayList<>();
        int posIndex = 0,negIndex = 0,k=0;
        while(posIndex < posArr.size() && negIndex < negArr.size()){
            if(k%2==0)
            res.add(posArr.get(posIndex++));
            else
            res.add(negArr.get(negIndex++));
            k++;
        }
        while(posIndex < posArr.size()){
           res.add(posArr.get(posIndex++));
        }
        while(negIndex < negArr.size()){
            res.add(negArr.get(negIndex++));   
        }
         
        arr.clear();
        arr.addAll(res);
        // code here
    }
}