class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        n= n/3;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> k : map.entrySet())
        {
            int key = k.getKey();
            int value = k.getValue();

            if(value>n)
            res.add(key);

        }
        return res;

        
    }
}