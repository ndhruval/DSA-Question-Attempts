class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2 != 0)
        return false;

        int opencount =0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)== '(' || locked.charAt(i)== '0')
            opencount++;
            else
            opencount--;
            if(opencount <0)
            return false;
        }
        int closecount =0;
        for(int i =n-1;i>=0;i--)
        {
            if(s.charAt(i)== ')'|| locked.charAt(i)== '0')
            closecount++;
            else
            closecount--;
            if(closecount <0)
            return false;
        }
        return true;


        
    }
}