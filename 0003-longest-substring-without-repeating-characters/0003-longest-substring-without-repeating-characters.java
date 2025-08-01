class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int left =0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        for(int right =0;right<n;right++){
            if(set.contains(s.charAt(right))){
                while(left<right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left +1);

        }
        return maxLen;
        
    }
}