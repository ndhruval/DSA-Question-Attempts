class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<nums.length;j++)
            {
                int x = -(nums[i]+nums[j]);
                if(hashset.contains(x))
                {
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],x);
                    temp.sort(null);
                    res.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
        
    }
}