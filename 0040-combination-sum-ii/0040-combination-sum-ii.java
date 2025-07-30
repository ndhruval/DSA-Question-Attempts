class Solution 
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        function(candidates, 0, target,temp,list);
        return list;

        
    }
    public static void function(int[] nums, int ind, int target, List<Integer> temp, List<List<Integer>> list)
    {
        if(target == 0)
        {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind;i<nums.length;i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            if(nums[i]>target) break;

            temp.add(nums[i]);
            function(nums, i+1,target-nums[i],temp,list);
            temp.remove(temp.size() -1);
           
        }
    }
}