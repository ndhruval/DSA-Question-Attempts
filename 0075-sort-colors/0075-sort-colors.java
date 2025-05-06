class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twoes = 0;
        for(int value: nums){
            if(value == 0)
                zeroes++;
             else if(value == 1)
                ones++;
             else 
                twoes++;
            
        }
        int i = 0;
        while(i < zeroes)
            nums[i++] = 0;
        
        
        while(i < zeroes + ones)
            nums[i++] = 1;
        
        while (i < nums.length)
            nums[i++] = 2;
        
    }
}