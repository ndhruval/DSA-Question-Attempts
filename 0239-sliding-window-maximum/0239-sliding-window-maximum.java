class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0 || k <= 0)
        {
            return new int[0];
        }
        int[] result = new int[nums.length - k+1];
        int x=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i =0;i< nums.length;i++)
        {
            if(!dq.isEmpty() && dq.peekFirst() <= i-k)
            dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
            dq.pollLast();

            dq.offerLast(i);
            if(i>= k-1)
            result[x++] = nums[dq.peekFirst()];

        }
        return result;
    }
}