class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long x =(long) m*k;
        if(x> bloomDay.length)
        return -1;
        int max= Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++)
        {
            max = Math.max(max,bloomDay[i]);
            min = Math.min(min,bloomDay[i]);
        }
        int l =min, h = max,ans=0;
        while(l<= h)
        {
            int mid = l+ (h-l)/2;
            if(possible(bloomDay,m,k,mid))
            {
                ans =mid;
                h = mid-1;
            }
            else
            l = mid+1;

        }
        return ans;
        
    }
    public static boolean possible(int[] bloomDay, int m, int k, int day)
    {
        int cnt=0, b =0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=day)
            cnt++;
            else
            {
                b += cnt/k;
                cnt=0;
            }
        }
        b += cnt/k;
        return b>=m;

    }
}