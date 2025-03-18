class Solution {
    public int longestNiceSubarray(int[] nums) {
        int usedBits = 0;
        int start =0;
        int max = 0;

        for(int end =0;end<nums.length; ++end)
        {
            while((usedBits & nums[end])!=0)
            {
                usedBits ^= nums[start];
                start++;
            }
            usedBits |= nums[end];
            max = Math.max(max, end - start +1);
        }
        return max;
        
    }
}