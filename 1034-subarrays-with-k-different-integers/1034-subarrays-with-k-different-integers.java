class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingAtMost(nums,k)-slidingAtMost(nums,k-1);
        
    }
    public int slidingAtMost(int[] nums, int distinctK){
        Map<Integer,Integer> map = new HashMap<>();
        int left =0, totalCount =0;
        for(int right=0;right<nums.length;right++)
        {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>distinctK)
            {
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            totalCount += (right - left +1);

        }
        return totalCount;
    }
}