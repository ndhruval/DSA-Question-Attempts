class Solution {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[3];
        int left =0;
        int right =0;
        int len = s.length();
        int total =0;
        while(right<len)
        {
            char ch = s.charAt(right);
            if(ch== 'a')
            freq[0]++;
            else if(ch == 'b')
            freq[1]++;
            else
            freq[2]++;

            while( helper(freq) == true)
            {
                total += len-right;

                char leftchar = s.charAt(left);
                if(leftchar== 'a')
                freq[0]--;
                else if(leftchar == 'b')
                freq[1]--;
                else
                freq[2]--;

                left++;
            }
            right++;
        }
        return total;

        
    }
    public boolean helper(int freq[])
    {
        if(freq[0]>0 && freq[1]>0 && freq[2]>0)
        return true;
        return false;
    }
}