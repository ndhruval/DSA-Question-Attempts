class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length> threshold)
        return -1;
        int max =Integer.MIN_VALUE;;
        
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max, nums[i]);
            
        }
        int l =1, h = max;
        while(l<=h)
        {
            int mid= l+(h-l)/2;
            if(possible(nums, threshold, mid))
            {
                ans = mid;
                h= mid-1;
            }
            else
            l = mid+1;

        }
        return ans;
        
    }
    public static boolean possible(int[] nums, int t, int divisor)
    {
        int sum =0;
        for(int i=0;i<nums.length;i++)
        {
            sum += (nums[i] + divisor - 1) / divisor;
        }

        if(sum<= t)
        return true;
        else
        return false;
    }
}