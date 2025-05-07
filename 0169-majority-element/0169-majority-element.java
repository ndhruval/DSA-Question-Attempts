class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        n = (int)Math.floor(n/2);
        int k =-1;
        for(Map.Entry<Integer,Integer> mp : map.entrySet())
        {
            int v = mp.getValue();
            if(v>n)
            k= mp.getKey();
        }
        return k;

        
    }
}