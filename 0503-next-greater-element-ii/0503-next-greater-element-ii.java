class Solution 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        int nge[] = new int[nums.length];
        Arrays.fill(nge, -1);

        for(int i =0;i< nums.length;i++)
        {
            for(int j = i+1;j<2*nums.length -1;j++ )
            {
                int ind = j% nums.length;
                if(nums[ind]> nums[i])
                {
                nge[i] = nums[ind];
                break;}
            }
        }
        return nge;
        
    }
}