class Solution {
    public int findDuplicate(int[] nums) 
    {
        Arrays.sort(nums);
        int x = -1;
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]== nums[i+1])
            {
                x =nums[i];
                break;
            }
        }
        return x;
        
    }
}