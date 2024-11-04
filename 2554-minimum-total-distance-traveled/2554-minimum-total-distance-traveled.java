
class Solution {
    private static final long SAFE_MAX_VALUE = (1L << 53) - 1; // Max safe value for serialization

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Step 1: Sort both the robot list and the factory array by positions
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int m = robot.size();
        
        // Step 2: Expand factory positions based on their limits
        List<Integer> positions = new ArrayList<>();
        for (int[] fac : factory) {
            int pos = fac[0];
            int limit = fac[1];

            for (int j = 0; j < limit; j++) {
                positions.add(pos);
            }
        }

        int n = positions.size();
        long[][] memo = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        // Step 3: Solve using a helper function
        return solve(0, 0, robot, positions, memo);
    }

    private long solve(int i, int j, List<Integer> robot, List<Integer> positions, long[][] memo) {
        if (i == robot.size()) return 0;  // All robots are processed
        if (j == positions.size()) return SAFE_MAX_VALUE;  // No more positions available

        if (memo[i][j] != -1) return memo[i][j];

        // Option 1: Skip the current factory position
        long skip = solve(i, j + 1, robot, positions, memo);

        // Option 2: Use the current factory position
        long use = Math.abs(robot.get(i) - positions.get(j)) + solve(i + 1, j + 1, robot, positions, memo);

        // Store and return the minimum of the two options
        memo[i][j] = Math.min(skip, use);
        return memo[i][j];
    }
}