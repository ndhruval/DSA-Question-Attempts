class Solution {
    public int minChanges(int n, int k) {

        String s = Integer.toBinaryString(n);
        String t = Integer.toBinaryString(k);

        while (s.length() < t.length()) s = "0" + s;
        while (t.length() < s.length()) t = "0" + t;

        int x = s.length();
        int res =0;

        for(int i=0;i<x;i++)
        {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(s1 != t1)
            {
                if(s1!='1')
                return -1;

                else
                res++;
            }
        }
        return res;
        
    }
}