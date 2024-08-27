class Solution {
    public int majorityElement(int[] nums) {
        return majority(nums , nums.length-1, nums[nums.length-1]);
    }
    private int majority(int[] nums, int start, int major){
        int counter = 0;
        for(int i = start; i>=0; i--){
            counter += nums[i]==major ? 1 : -1;
            if(counter == -1) return majority(nums ,i, nums[i]);
        }
        return major;
    }
    
}