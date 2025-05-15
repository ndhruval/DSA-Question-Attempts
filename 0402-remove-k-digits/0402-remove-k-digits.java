class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++)
        {
            char ch = num.charAt(i);
            while(!st.isEmpty() && st.peek()>ch && k>0)
            {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(!st.isEmpty() && k>0)
        {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') 
        {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();


    }
}