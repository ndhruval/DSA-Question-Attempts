class Solution 
{
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);

        int left =0, right =0;
        while(left < g.length && right < s.length)
        {
            if(g[left] <= s[right])
            {
                left++;
                right++;
            }
            else
            {
                right++;
            }
        }
        return left;
        
    }
}