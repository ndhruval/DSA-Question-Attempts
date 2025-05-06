class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i =0;i<nums.length;i++)
        {
            HashSet<Integer> set = new HashSet<>();
            for(int j =i+1;j<nums.length;j++)
            {
                int x = -(nums[i]+ nums[j]);
                if(set.contains(x))
                {
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],x);
                    temp.sort(null);
                    res.add(temp);
                }
                set.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }
}