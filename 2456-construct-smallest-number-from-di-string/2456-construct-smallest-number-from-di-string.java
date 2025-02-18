class Solution {
    public String smallestNumber(String pattern) {

        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for(int i=0;i<= pattern.length();i++)
        {
            ans.append((char)('1'+i));
            if(i == pattern.length() || pattern.charAt(i)=='I')
            {
                ans.append(temp);
                temp.setLength(0);
            }
            else
            {
                temp.insert(0,ans.charAt(ans.length()-1));
                ans.setLength(ans.length()-1);
                
            }
        }
        return ans.toString();
        
    }
}