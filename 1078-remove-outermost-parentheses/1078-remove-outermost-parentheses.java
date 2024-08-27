class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        String str = "";
        int balance =0;
        int len = s.length();
        for(int i =0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                if(balance > 0)
                str += ch;
                balance++;
            }
            else
            {
                balance--;
                if(balance>0)
                str += ch;
            }
        }
        return str;
    }
}