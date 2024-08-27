class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        char arr[] = s.toCharArray();
        String str = "";
        int balance =0,index=0;

        int len = s.length();
        for(char ch : arr)
        {
           
            if(ch == '(')
            {
                if(balance > 0)
                arr[index++] = '(';
                balance++;
            }
            else
            {
                balance--;
                if(balance>0)
                arr[index++] = ')';
            }
        }
        return new String(arr, 0, index);
    }
}