class Solution {
    public String reverseWords(String s) {
        String temp = "";
        String ans = "";
        s = s.trim();  // Remove leading and trailing spaces

        int l = s.length();

        for (int i = l - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                temp = ch + temp;
            } else {
                // Add word to the answer only if temp is not empty
                if (!temp.equals("")) {
                    if (!ans.equals("")) {
                        ans = ans + " " + temp;
                    } else {
                        ans = temp;
                    }
                    temp = "";  // Reset temp for the next word
                }
            }
        }

        // Add the last word if there's any left in temp
        if (!temp.equals("")) {
            if (!ans.equals("")) {
                ans = ans + " " + temp;
            } else {
                ans = temp;
            }
        }

        return ans;
    }
}
