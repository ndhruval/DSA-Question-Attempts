

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, 0);
        return ans;
    }

    public void helper(int[] nums, List<List<Integer>> ans, int ind) {
        if (ind == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) ds.add(num);
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            helper(nums, ans, ind + 1);
            swap(i, ind, nums); // backtrack
        }
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

 
    }

