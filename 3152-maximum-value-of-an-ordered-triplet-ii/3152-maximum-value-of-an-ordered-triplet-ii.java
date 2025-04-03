class Solution {
    public long maximumTripletValue(int[] nums) {
        int pre_max[] = new int[nums.length];
        int suff_max[] = new int[nums.length];
        pre_max[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            pre_max[i] = Math.max(pre_max[i-1],nums[i]);
        }
        suff_max[nums.length-1]= nums[nums.length-1];
        for(int j =nums.length-2;j>=0;j--)
        {
            suff_max[j] = Math.max(suff_max[j+1],nums[j]);
        }
        long max = Long.MIN_VALUE;
        for(int i=1;i<nums.length-1;i++)
        {
           long x = (long)(pre_max[i-1]-nums[i])*suff_max[i+1];
            max = Math.max(max,x);
        }
        if(max<0)
        return 0;
        else
        return max;

        
    }
}