class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count =0;
        for(Map.Entry<Integer,Integer> m :map.entrySet())
        {
            int key = m.getKey();
            int value = m.getValue();
            if(value%2!=0)
            return false;
            if(value>2)
            count += value/2;
            else
            count++;


        }
        if(count == nums.length/2)
        return true;
        return false;
        
    }
}