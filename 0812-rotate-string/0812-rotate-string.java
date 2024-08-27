class Solution 
{
    public boolean rotateString(String s, String goal) 
    {
        if(s.length() != goal.length())
        return false;
        String d = s+s;
        if(d.contains(goal))
        return true;
        else
        return false;

        
    }
}