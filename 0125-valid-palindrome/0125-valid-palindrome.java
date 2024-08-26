class Solution 
{
    public boolean isPalindrome(String s) 
    {
        if(s.equals(""))
        return true;
        if(s.length()==1)
        return true;
        int l = s.length();
        String str = "";
        for(int i=0;i<l;i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            str = str +ch;
        }
        str= str.toLowerCase();
        String y ="";
        for(int i=str.length()-1;i>=0;i--)
        {
            char d = str.charAt(i);
            y= y+ d;

        }
        if(str.equals(y))
        return true;
        else
        return false;
        
    }
}