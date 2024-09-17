class Solution 
{
    public int[] rearrangeArray(int[] nums) 
    {
        int len = nums.length;
        int n=len/2;
        int pos[] = new int[n];
        int neg[] = new int[n];
        int i =0, j =0;

        for(int k =0;k<len;k++)
        {
            if(nums[k]>= 0)
            pos[i++] = nums[k];
            else
            neg[j++] = nums[k];
        }
        i=0;j=0;
        for(int k =0;k<len;k += 2)
        {
            nums[k] = pos[i++];
            nums[k+1] = neg[j++];

        }
        return nums;
        
    }
}