class Solution {
    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int maxSofar = nums[0];
        int minSofar = nums[0];
        int result = maxSofar;

        for(int i =1;i<nums.length;i++){
            int current = nums[i];

            int temp = Math.max(current, Math.max(maxSofar * current, minSofar*current));
            minSofar = Math.min(current, Math.min(maxSofar * current, minSofar*current));
            maxSofar = temp;

            result = Math.max(maxSofar, result);
        }
        return result;
        
    }
}