class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        int maxEnding = nums[0];
        int result = nums[0];

        for(int i=1;i< nums.length;i++)
        {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            result = Math.max(maxEnding, result);
        }
        return result;
        
        
    }
}