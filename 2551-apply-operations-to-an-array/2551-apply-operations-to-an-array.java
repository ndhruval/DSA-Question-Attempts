class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]== nums[i+1])
            {
                nums[i]= nums[i]*2;
                nums[i+1]=0;
            }
        }

        int nonZeroIndex = 0;
        for (int iterateIndex = 0; iterateIndex < n; iterateIndex++) {
            if (nums[iterateIndex] != 0) {
                nums[nonZeroIndex++] = nums[iterateIndex];
            }
        }

        while (nonZeroIndex < n) {
            nums[nonZeroIndex++] = 0;
        }

        return nums;
        
    }
}