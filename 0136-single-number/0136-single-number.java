class Solution 
{
    public int singleNumber(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i< nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        }
       for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
        
    }
}