class Solution {
    public int minOperations(int[] nums) {
        int operations =0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0)
            {
                operations++;
                nums[i]=1;
                if(nums[i+1]==0)
                nums[i+1]=1;
                else
                nums[i+1]=0;
                if(nums[i+2]==0)
                nums[i+2]=1;
                else
                nums[i+2]=0;
            }
            else
            continue;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            return -1;
        }
        return operations;
        
    }
}