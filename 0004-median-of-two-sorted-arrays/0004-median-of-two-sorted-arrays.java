import java.util.*;
class Solution
 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n= nums1.length + nums2.length;
        int a[] = new int[n];int k=0,j=0,i=0;
        double median;
        while(i<nums1.length)
        {
            a[k++]= nums1[i++];
        }
        while(j< nums2.length)
        a[k++]= nums2[j++];

        Arrays.sort(a);
        if(n%2==0)
        {
            median= (double)(a[n/2] + a[n/2-1])/2;
            
        }
        else
        median = a[(int)n/2];
        return median;
    }
}