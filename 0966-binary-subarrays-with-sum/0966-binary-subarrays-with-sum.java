class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l =0;
        int ans =0;
        int sum=0;
        for(int r =0;r<nums.length;r++)
        {
            sum += nums[r];
            while(l<r && sum>goal)
            {
                sum -= nums[l];
                l++;
            }
            if(sum == goal)
            {
                int temp = l;
                while(temp<r && nums[temp]==0)
                {
                    temp++;
                    ans++;
                }
                ans++;
            }

        }
        return ans;
        
    }
}