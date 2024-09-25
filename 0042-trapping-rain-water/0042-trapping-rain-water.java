class Solution 
{
    public int trap(int[] height) 
    {
        int prefix[] = new int[height.length];
        int suffix[] = new int[height.length];
        int sum =0;

        prefix[0] = height[0];
        suffix[height.length -1] = height[height.length -1];

        for(int i =1;i< height.length;i++)
        {
            prefix[i] = Math.max(height[i], prefix[i-1]);  
        }
        for(int i= height.length -2;i>=0;i--)
        {
            suffix[i] = Math.max(height[i],suffix[i+1]);
        }

        for(int i=0;i< height.length;i++)
        {
            int x = Math.min(prefix[i], suffix[i]) - height[i];
            sum += x;
        }
        return sum;
        
    }
}