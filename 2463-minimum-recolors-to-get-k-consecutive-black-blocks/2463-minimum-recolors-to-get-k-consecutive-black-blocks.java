class Solution {
    public int minimumRecolors(String blocks, int k) {
        
               int n = blocks.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {  // Fixed loop condition
            String s = blocks.substring(i, i + k);
            int countW = s.length() - s.replace("W", "").length(); // Count 'W' occurrences
            min = Math.min(min, countW);
        }

        return min == Integer.MAX_VALUE ? 0 : min;  // Handle edge cases
    }
}