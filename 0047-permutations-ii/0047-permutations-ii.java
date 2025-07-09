class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        helper(nums,set,0);
        return new ArrayList<>(set);
    }
    public void helper(int[] nums, HashSet<List<Integer>> set, int index){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            set.add(ds);
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            helper(nums,set,index+1);
            swap(i,index,nums);
        }
    }
    public void swap(int i, int index, int[] nums){
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }
}