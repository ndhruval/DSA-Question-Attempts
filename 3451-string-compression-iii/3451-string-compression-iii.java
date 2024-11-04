class Solution 
{
    public String compressedString(String word) 
    {
        String comp = "";
        if(word.length() == 1)
        {
            comp = "1" + word;
            return comp;
        }
        
            int count =1;
            char y =word.charAt(0);
            for(int i=1;i< word.length();i++)
            {
                if(word.charAt(i)== y && count<9)
                {
                    count++;
                   

                }
                else
                {
                    comp = comp + Integer.toString(count) + y;
                    count = 1;
                    y= word.charAt(i);
                    

                }
            }
            comp = comp + Integer.toString(count) + y;

        
        return comp;
        
    }
}