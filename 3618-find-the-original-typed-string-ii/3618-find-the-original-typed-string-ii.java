import java.util.*;

class Solution {
    public int possibleStringCount(String word, int k) {
        final int MOD = 1_000_000_007;
        List<Integer> groupCounts = new ArrayList<>();
        int n = word.length();

        // Step 1: Group repeated characters
        for (int i = 0; i < n;) {
            int count = 1;
            char c = word.charAt(i++);
            while (i < n && word.charAt(i) == c) {
                count++;
                i++;
            }
            groupCounts.add(count);
        }

        // Step 2: Total combinations
        long total = 1;
        for (int count : groupCounts) {
            total = (total * count) % MOD;
        }

        int groupSize = groupCounts.size();
        if (k <= groupSize) return (int) total;

        // Step 3: DP to count combinations with < k original characters
        int maxSize = k - 1;
        int[] dp = new int[maxSize + 1];
        dp[0] = 1;

        for (int count : groupCounts) {
            int[] newDp = new int[maxSize + 1];
            long windowSum = 0;
            for (int s = 0; s <= maxSize; s++) {
                if (s - 1 >= 0) {
                    windowSum = (windowSum + dp[s - 1]) % MOD;
                }
                if (s - count - 1 >= 0) {
                    windowSum = (windowSum - dp[s - count - 1] + MOD) % MOD;
                }
                newDp[s] = (int) windowSum;
            }
            dp = newDp;
        }

        // Step 4: Count all combinations of length < k
        long invalid = 0;
        for (int i = 0; i <= maxSize; i++) {
            invalid = (invalid + dp[i]) % MOD;
        }

        // Final Answer
        return (int) ((total - invalid + MOD) % MOD);
    }
}
