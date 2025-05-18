class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int m = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;

        // Count characters in t
        for (int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        for (int r = 0; r < n; r++) {
            char currChar = s.charAt(r);
            map.put(currChar, map.getOrDefault(currChar, 0) - 1);
            if (map.get(currChar) >= 0) {
                count++;
            }

            // Shrink the window when all characters are matched
            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                if (map.get(leftChar) > 0) {
                    count--;
                }
                l++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
