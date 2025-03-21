class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int maxSum =0;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
            maxSum += nums[i];
        }
        int l = max;
        int h = maxSum;
        while(l<=h)
        {
            int mid = l+ (h-l)/2;
            int partitions = countPartitions(nums, mid);
            if(partitions>k)
            l = mid+1;
            else
            h = mid-1;
        }
        return l;

        
    }
    public static int countPartitions(int[] nums, int maxSum)
    {
        int partitions=1;
        int subarraySum =0;
        for(int i=0;i<nums.length;i++)
        {
            if(subarraySum + nums[i]<= maxSum)
            {
                subarraySum += nums[i];
            }
            else
            {
                partitions++;
                subarraySum = nums[i];
            }
        }
        return partitions;
    }
}