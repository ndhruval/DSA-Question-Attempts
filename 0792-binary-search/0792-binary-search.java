class Solution 
{
    public int search(int[] nums, int target)
    {
        int e= nums.length -1;
        int x= binsearch(nums, target, 0, e);
        return x;
        
    }
    public static int binsearch(int[] nums, int target, int s, int e)
    {
     
        if(s>e)
        return -1;
        int m = s+(e-s)/2;
        if(nums[m]== target)
        return m;
        if(target < nums[m])
        {
            return binsearch(nums, target, s, m-1 );
        }
        return binsearch(nums, target, m+1,e);
    
    }
}