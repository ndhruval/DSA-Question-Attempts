class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = s.length() - 1;

        while (i >= 0) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch) || ch == ']') {
                stack.push(String.valueOf(ch));
                i--;
            } 
            else if (ch == '[') {
                // Start decoding: Pop characters until ']'
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("]")) {
                    temp.append(stack.pop());
                }
                stack.pop(); // remove the ']'

                // Move i to extract full digit before this [
                i--;
                int base = 1;
                int k = 0;
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    k = k + (s.charAt(i) - '0') * base;
                    base *= 10;
                    i--;
                }

                // Repeat decoded string
                String repeated = temp.toString().repeat(k);
                stack.push(repeated);
            } 
            else {
                i--;
            }
        }

        // Collect all parts from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
