class Solution 
{
    public int longestSubarray(int[] nums, int limit) 
    {
        Deque<Integer> inc = new ArrayDeque<>();
        Deque<Integer> dec = new ArrayDeque<>();

        int res = 0;
        int left = 0;
        for(int right =0;right< nums.length; right++)
        {
            while(!inc.isEmpty() && inc.getLast() > nums[right])
            inc.removeLast();

            while(!dec.isEmpty() && dec.getLast() < nums[right])
            dec.removeLast();

            inc.addLast(nums[right]);
            dec.addLast(nums[right]);

            while(dec.getFirst()- inc.getFirst()>limit)
            {
                if(dec.getFirst() == nums[left])
                dec.removeFirst();
                if(inc.getFirst() == nums[left])
                inc.removeFirst();
                left++;
            }
            res = Math.max(res, right - left+1);
        }
        return res;
        
    }
}