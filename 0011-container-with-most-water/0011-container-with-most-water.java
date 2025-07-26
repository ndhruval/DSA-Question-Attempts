class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int left = 0, right = n-1;
        int w =0, h=0, min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(left<right)
        {
            w = right - left;
            min = Math.min(height[right], height[left]);
            int area = w*min;
            max = Math.max(max, area);
            if(height[left]<height[right])
            left++;
            else if(height[right]<height[left])
            right--;
            else{
                left++;
                right--;
            }
        }
        return max;   
    }
}