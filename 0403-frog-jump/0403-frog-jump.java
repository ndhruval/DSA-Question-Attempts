class Solution {
    public boolean canCross(int[] stones) {

        if(stones[1]-stones[0] != 1) return false;
        boolean dp[][] = new boolean[stones.length][stones.length];
        return function(0,1,stones,dp);

                
    }
    public static boolean function(int prev, int curr, int[] stones, boolean[][] dp){
        if(curr == stones.length -1) return true;
        if(dp[prev][curr] == true) return false;
        
        int lastjump = stones[curr] - stones[prev];
        int next = curr +1;
        while(next < stones.length && stones[next]<= stones[curr]+ lastjump + 1){
            int nextJump = stones[next] - stones[curr];

            int jump = nextJump - lastjump;
            if(jump>=-1 && jump<=1)
            {
                if(function(curr, next, stones,dp)) return true;
            }
            next++;
        }
        dp[prev][curr] = true;
        return false;

        
    }
}