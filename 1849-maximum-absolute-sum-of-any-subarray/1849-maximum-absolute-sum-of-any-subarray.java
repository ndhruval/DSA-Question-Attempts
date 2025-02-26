class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int minpre= 0, maxpre =0;
        int presum =0;
        for(int i=0;i<nums.length;i++)
        {
            presum += nums[i];
            minpre = Math.min(minpre, presum);
            maxpre = Math.max(maxpre, presum);
        }
        return maxpre-minpre;

        
    }
}