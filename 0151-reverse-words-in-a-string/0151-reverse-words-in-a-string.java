class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        Stack<String> st = new Stack<>();
        String temp = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                temp += c;
            } else if (temp.length() > 0) { // to skip multiple spaces
                st.push(temp);
                temp = "";
            }
        }
        st.push(temp); // push the last word

        String ans = "";
        while (!st.isEmpty()) {
            ans += st.pop();
            if (!st.isEmpty()) {
                ans += " ";
            }
        }
        return ans;
    }
}
