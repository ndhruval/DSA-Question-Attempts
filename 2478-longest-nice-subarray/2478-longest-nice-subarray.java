class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans =1;
        int l =0, h = nums.length;
        while(l<=h)
        {
            int mid = l+ (h-l)/2;
            if(canformnice(mid,nums))
            {
                ans = mid;
                l = mid+1;
            }
            else
            h = mid-1;
        }
        return ans;
        
    }
    public static boolean canformnice(int length, int[] nums)
    {
        if(length<=1)
        return true;

        for(int start =0;start<= nums.length - length; ++start)
        {
            int bitmask = 0;
            boolean isNice = true;

            for(int pos = start;pos< start+length;++pos)
            {
                if((bitmask & nums[pos])!=0)
                {
                    isNice = false;
                    break;
                }
                bitmask |= nums[pos];
            }
            if(isNice)
            return true;
        }
        return false;
    }
}