class Solution {
    public int minimumLength(String s) {

        int al[] = new int[26];
        Arrays.fill(al,0);
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            al[c - 'a']++;
        }
        int count =0;
        for(int i=0;i<26;i++)
        {
            if(al[i]>0)
            {
                if(al[i]%2==0)
                {
                    count += 2;
                }
                else
                count += 1;
            }
        }
        return count;
    }
}