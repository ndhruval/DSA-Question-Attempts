class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n= nums.length;
        int count =0;
        int modcount[] = new int[k];
        modcount[0] = 1;
        int sum =0;

        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            int remainder = sum%k;

            if(remainder<0)
            remainder += k;

            count += modcount[remainder];
            modcount[remainder]++;
        }
        return count;
        
    }
}