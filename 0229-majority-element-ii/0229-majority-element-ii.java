class Solution 
{
    public List<Integer> majorityElement(int[] nums) 
    {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int n = nums.length/3;
        for(int num: map.keySet())
        {
            if(map.get(num)>n)
            result.add(num);
        }
        return result;

        
    }
}