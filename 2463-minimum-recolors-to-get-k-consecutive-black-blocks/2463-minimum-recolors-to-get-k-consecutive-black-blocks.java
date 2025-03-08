class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<=n-k;i++)
        {
            String s = blocks.substring(i,i+k);
            int x= s.length() - s.replace(String.valueOf('W'), "").length();
            min = Math.min(min,x);

            
        }
        return min;

        
    }
}