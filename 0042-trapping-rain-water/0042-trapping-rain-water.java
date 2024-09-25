class Solution 
{
    public int trap(int[] a) 
    {
        int l =0, r = a.length -1;
        int m_l =0, m_r =0;
        int res =0;
        while(l<= r)
        {
            if(a[l]<= a[r])
            {
                if(a[l]>= m_l)
                m_l = a[l];
                else
                res += m_l - a[l];

                l++;

            }
            else
            {
                if(a[r]>=m_r)
                m_r = a[r];
                else
                res += m_r -a[r];

                r--;
            }
        }
        return res;
        
    }
}