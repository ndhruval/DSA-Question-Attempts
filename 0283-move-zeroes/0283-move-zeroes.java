class Solution {
    public void moveZeroes(int[] nums) {

        int x=-1, n=nums.length;

        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                x++;
                nums[x]= nums[i];
            }

        }
        while(x<n-1)
        {
            x++;
            nums[x] = 0;
        }
        

        
    }
}