import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        function(0, candidates, target, list, temp);
        return list;
    }

    public void function(int ind, int[] nums, int target, List<List<Integer>> list, List<Integer> temp) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (ind == nums.length || target < 0) {
            return;
        }

       
        temp.add(nums[ind]);
        function(ind, nums, target - nums[ind], list, temp);
        temp.remove(temp.size() - 1);

      
        function(ind + 1, nums, target, list, temp);
    }
}
