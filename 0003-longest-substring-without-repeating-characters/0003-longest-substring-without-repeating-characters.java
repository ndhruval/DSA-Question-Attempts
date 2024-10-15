class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        Deque<Character> st = new ArrayDeque<>();
        int l = s.length();
        int left =0;
        int res =0;
        

        for(int right =0;right<l;right++)
        {
            while(!st.isEmpty() && st.contains(s.charAt(right)))
            {
                st.removeFirst();
                left++;
            }
            st.addLast(s.charAt(right));
            res = Math.max(res,st.size());
        }
        return res;

        
    }
}