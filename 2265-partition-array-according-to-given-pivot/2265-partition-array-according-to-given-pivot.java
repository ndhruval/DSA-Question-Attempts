class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int m=0;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                ans[m]=nums[i];
                m++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                ans[m]=nums[i];
                m++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                ans[m]=nums[i];
                m++;
            }
        }
        return ans;
    }
}