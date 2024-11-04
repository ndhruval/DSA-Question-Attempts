class Solution 
{
    public String compressedString(String word) 
    {
        StringBuilder comp = new StringBuilder();

        if (word.length() == 1) 
        {
             return "1" + word;
        }
            

        int count = 1;
        char y = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == y && count < 9) {
                count++;

            } else {
                comp.append(count).append(y);
                count = 1;
                y = word.charAt(i);

            }
        }
        comp.append(count).append(y);

        return comp.toString();

    }
}