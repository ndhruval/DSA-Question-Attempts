class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt1 = findSubs(nums, goal);
        int cnt2 = findSubs(nums, goal-1);
        return cnt1 - cnt2;
        
    }
    public int findSubs(int[] nums, int goal)
    {
        if(goal<0)
        return 0;

        int sum=0, count=0, left =0;
        for(int right =0;right <nums.length;right++)
        {
            sum += nums[right];
            while(sum>goal)
            {
                sum -= nums[left];
                left++;
            }
            count += right - left +1;
        }
        return count;
    }
}