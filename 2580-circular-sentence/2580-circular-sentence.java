class Solution 
{
    public boolean isCircularSentence(String sentence) 
    {
        int l = sentence.length();
        for(int i=0;i<l;i++)
        {
            if(i== l-1)
            {
                if(sentence.charAt(i) != sentence.charAt(0))
                return false;
            }
            else
            {
                if(sentence.charAt(i)== ' ')
                {
                    if(sentence.charAt(i-1) != sentence.charAt(i+1))
                    return false;
                }
            }
        }
        return true;
        
    }
}