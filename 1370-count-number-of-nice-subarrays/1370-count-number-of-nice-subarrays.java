class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt1 = findSubs(nums,k);
        int cnt2 = findSubs(nums, k-1);

        return cnt1 - cnt2;
        
    }
    public int findSubs(int[] nums, int k)
    {
        if(k<0)
        return 0;

        int left =0;
        int count =0;
        int total=0;
        for(int right =0;right < nums.length;right++)
        {
            if(nums[right]%2 !=0)
            count++;
            while(count>k)
            {
                if(nums[left]%2 !=0)
                count--;
                left++;
            }
            total += right - left +1;
        }
        return total;
    }
}