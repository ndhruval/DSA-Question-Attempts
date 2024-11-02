class Solution {
    public String makeFancyString(String s) {
        int l = s.length();
        if (l < 3) {
            return s; // If the string length is less than 3, return it as is.
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)); // Add the first character
        sb.append(s.charAt(1)); // Add the second character

        for (int i = 2; i < l; i++) {
            // Check if the current character forms three consecutive identical characters
            if (!(s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2))) {
                sb.append(s.charAt(i)); // Only add if it's not forming a triplet
            }
        }

        return sb.toString();
    }
}
