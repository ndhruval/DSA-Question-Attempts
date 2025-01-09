class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Handle edge cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Split the problem into two linear rob problems
        int ans1 = robLinear(nums, 0, n - 2); // Exclude the last house
        int ans2 = robLinear(nums, 1, n - 1); // Exclude the first house

        return Math.max(ans1, ans2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // Two houses back
        int prev1 = 0; // One house back

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2; // Rob current house
            int nonPick = prev1; // Skip current house

            int curr = Math.max(pick, nonPick); // Max profit at this house
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1; // Maximum profit at the last house
    }
}
