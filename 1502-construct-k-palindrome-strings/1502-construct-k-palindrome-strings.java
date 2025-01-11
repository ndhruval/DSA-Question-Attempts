class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
        return false;
        int freq[] = new int[26];
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            freq[c- 'a']++;
        }
        int count =0;
        for(int i=0;i<26;i++)
        {
            if(freq[i] !=0)
            {
                if(freq[i]%2 !=0)
                count++;

            }
        }
        if(count > k)
        return false;
        else
        return true;

        
    }
}