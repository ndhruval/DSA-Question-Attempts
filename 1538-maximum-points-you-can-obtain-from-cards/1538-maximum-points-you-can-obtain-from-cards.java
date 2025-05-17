class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // Step 1: take the first k cards from the front
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }
        
        int maxScore = total;

        // Step 2: slide window - remove from end of left, add from right
        for (int i = 1; i <= k; i++) {
            total -= cardPoints[k - i];       // remove from front
            total += cardPoints[n - i];       // add from back
            maxScore = Math.max(maxScore, total);
        }

        return maxScore;
    }
}
