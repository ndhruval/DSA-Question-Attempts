class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        // for(int i = 0; i< nums.length; i++){
        //     sum = 0;
        //     //sum += nums[i];
        //     for(int j=i; j<nums.length; j++){
        //         sum += nums[j];
        //         max = Math.max(max, sum);
        //     }
        // }

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            max= Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}