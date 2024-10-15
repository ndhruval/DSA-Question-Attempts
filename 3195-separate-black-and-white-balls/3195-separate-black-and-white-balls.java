class Solution 
{
    public long minimumSteps(String s) 
    {
        char[] ch = s.toCharArray();
        int l = s.length();
        int count1 =0 ; long count2 =0;
        for(int i=l-1;i>=0;i--)
        {
            if(ch[i] == '0')
            count1++;
            if(ch[i] == '1')
            {
                count2 += count1;
               
            }
            

        }
        return count2;
        
    }
}