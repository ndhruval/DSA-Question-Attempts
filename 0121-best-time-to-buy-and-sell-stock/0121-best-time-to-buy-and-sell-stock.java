class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
        int maxPro = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;;
        for(int i=0;i<n;i++)
        {
           minPrice = Math.min(minPrice, prices[i]);
           maxPro = Math.max(maxPro,prices[i] - minPrice);

        }
        if(maxPro < 0)
        return 0;
        return maxPro;
        
    }
}