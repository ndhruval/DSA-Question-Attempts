class Solution {
    public int search(int[] nums, int target) {
        int l =0, h = nums.length -1;
        int pivot = -1;
        while(l<=h)
        {
            int mid = l +(h-l)/2;
            if(target == nums[mid])
            {
                return mid;
            }
            if(nums[l]<= nums[mid])
            {
                if(nums[l]<= target && target<= nums[mid])
                h =mid-1;
                else
                l = mid +1;
            }
            else if(nums[mid]<= nums[h])
            {
                if(nums[mid]<= target && target<= nums[h])
                l = mid+1;
                else
                h = mid-1;

            }
            

        }
        return -1;
        
    }

   
}