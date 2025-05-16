class Solution {
    public int largestRectangleArea(int[] heights) {
        int ple[] = new int[heights.length];
        int nle[] = new int[heights.length];

        int n= heights.length;

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            ple[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>heights[i])
            {
                st.pop();
            }
            nle[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        st.clear();

        int maxi=0;

        for(int i=0;i<n;i++)
        {
            maxi = Math.max(maxi, heights[i]* (nle[i]-ple[i]-1));
        }
        return maxi;

      
        
    }
}