class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int l = Integer.MIN_VALUE;
        int h =0;
        for(int i=0;i<weights.length;i++)
        {
            l = Math.max(l,weights[i]);
            h += weights[i];
        }
        int ans=0;
        while(l<=h)
        {
            int mid= l +(h-l)/2;
            if(possible(weights,mid)<= days)
            {
                ans = mid;
                h = mid-1;
            }
            else
            l = mid+1;
        }
        return ans;

        
    }
    public static int possible(int[] weights, int cap)
    {
        int days=1;
        int load =0;
        for(int i=0;i<weights.length;i++)
        {
            if(load+ weights[i]> cap)
            {
                days++;
                load = weights[i];
            }
            else
            {
                load+= weights[i];
            }
        }
        return days;
    }
}