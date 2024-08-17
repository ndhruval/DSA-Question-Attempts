class Solution 
{
    public void sortColors(int[] nums) 
    {
        int cnt[] = new int[3];
        for(int i =0;i< nums.length;i++)
        {
            if(nums[i]==0)
            cnt[0]++;
            else if(nums[i]==1)
            cnt[1]++;
            else
            cnt[2]++;
        }
        int x=0;
        for(int i=0;i<cnt[0];i++)
        {
            nums[x]=0;
            x++;
        }
        for(int i=0;i<cnt[1];i++)
        {
            nums[x] = 1;
            x++;
        }
        for(int i=0; i<cnt[2];i++)
        {
            nums[x] =2;
            x++;
        }
       
        
    }
}