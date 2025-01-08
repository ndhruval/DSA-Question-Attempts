class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Loop through each pair of strings
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // Check if str2 is long enough to contain str1 as a prefix and suffix
        if (len2 < len1) return false;

        // Check if str1 is a prefix of str2
        boolean isPrefix = str2.substring(0, len1).equals(str1);

        // Check if str1 is a suffix of str2
        boolean isSuffix = str2.substring(len2 - len1).equals(str1);

        return isPrefix && isSuffix;
    }
}
