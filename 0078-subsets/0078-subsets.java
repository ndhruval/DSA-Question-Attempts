class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        ArrayList<Integer> al = new ArrayList<Integer>();
        subss(0,ans,nums,n,al);
        return ans;




        
    }
    public static void subss(int i, List<List<Integer>> ans, int[] nums, int n,ArrayList<Integer> al)
    {
        if(i>=n)
        {
            ans.add(new ArrayList<Integer>(al));
            return;

        }
        al.add(nums[i]);
        subss(i+1,ans,nums,n,al);
        al.remove(al.size()-1);
        subss(i+1,ans,nums,n,al);
    }

}