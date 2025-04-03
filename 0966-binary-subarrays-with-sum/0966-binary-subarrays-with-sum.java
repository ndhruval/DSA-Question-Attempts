class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cntN = findSub(nums,goal);
        //no of subArray with sum<= goal-1
        int cntM = findSub(nums,goal-1);
        return cntN-cntM;
        
    }
    public int findSub(int[] nums,int goal){
        if(goal < 0){
            return 0;
        }
        int l = 0,r = 0,sum = 0,cnt = 0;
        while(r < nums.length){
            sum+= nums[r];
            while(sum > goal){
                sum = sum- nums[l];
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}