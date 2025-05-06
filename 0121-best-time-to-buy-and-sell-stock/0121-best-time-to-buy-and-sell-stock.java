class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxPro = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            minVal = Math.min(minVal,prices[i]);
            maxPro = Math.max(maxPro, prices[i]-minVal);
        }
        if(maxPro<0)
        return 0;
        return maxPro;
        
    }
}