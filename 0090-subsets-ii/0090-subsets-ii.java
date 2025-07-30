class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort to ensure duplicate handling
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Subset(0, nums, nums.length, temp, set);
        return new ArrayList<>(set);
    }

    public void Subset(int ind, int[] nums, int N, List<Integer> temp, HashSet<List<Integer>> set) {
        if (ind == N) {
            set.add(new ArrayList<>(temp));  // Add a copy to avoid mutation
            return;
        }

        // Include nums[ind]
        temp.add(nums[ind]);
        Subset(ind + 1, nums, N, temp, set);

        // Backtrack and exclude nums[ind]
        temp.remove(temp.size() - 1);
        Subset(ind + 1, nums, N, temp, set);
    }
}
