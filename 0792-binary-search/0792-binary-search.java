class Solution {
    public int search(int[] nums, int target) {
        if(nums.length ==1)
        {
            if(target == nums[0])
            return 0;
            else
            return -1;
        }
        int l =0, u = nums.length-1;
        while(l<=u)
        {
            int mid = l + (u-l)/2;
            if(target< nums[mid])
            u = mid-1;
            if(target>nums[mid])
            l = mid+1;
            if(target == nums[mid])
            return mid;
        }
        return -1;
        
    }
}