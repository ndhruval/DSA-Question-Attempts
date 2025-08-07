class Solution {
    public boolean canCross(int[] stones) {
        // A map for O(1) lookup of a stone's index given its position.
        HashMap<Integer, Integer> stoneMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            stoneMap.put(stones[i], i);
        }

        Boolean[][] memo = new Boolean[stones.length][stones.length];
        
        return solve(0, 0, stones, stoneMap, memo);
    }

    private boolean solve(int index, int lastJump, int[] stones, HashMap<Integer, Integer> stoneMap, Boolean[][] memo) {
        if (index == stones.length - 1) {
            return true;
        }

        if (memo[index][lastJump] != null) {
            return memo[index][lastJump];
        }

        for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextPosition = stones[index] + nextJump;
                if (stoneMap.containsKey(nextPosition)) {
                    int nextIndex = stoneMap.get(nextPosition);
                    if (solve(nextIndex, nextJump, stones, stoneMap, memo)) {
                        memo[index][lastJump] = true;
                        return true;
                    }
                }
            }
        }

        memo[index][lastJump] = false;
        return false;
    }
}