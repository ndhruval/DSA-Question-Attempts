class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if (c == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }

            else {
                st.push(c);
            }

        }
        StringBuilder s1 = new StringBuilder();
        while(!st.isEmpty())
        {
            s1.append(st.pop());
        }
        s1 = s1.reverse();
        s = s1.toString();

        Stack<Character> st1 = new Stack<>();

        StringBuilder t1 = new StringBuilder();
        for(int i =0;i<t.length();i++)
        {
            char c = t.charAt(i);
            if(c == '#')
            {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }
            else {
                st1.push(c);
            }

        }
        while(!st1.isEmpty())
        {
            t1.append(st1.pop());
        }
        t1 = t1.reverse();
        t = t1.toString();

        if(s.equals(t)== true)
        return true;
        else
        return false;

        
    }
}