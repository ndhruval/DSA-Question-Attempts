class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];
        int maxArea =0;

        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[0][j]=='1')
            mat[0][j] = 1;
            else
            mat[0][j] = 0;
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]== '1')
                mat[i][j] = mat[i-1][j] + 1;
                else
                mat[i][j]=0;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            maxArea = Math.max(maxArea, maximum(mat[i]));
        }
        return maxArea;



        
    }

    public int maximum(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        int n= arr.length;
        int element;
        int pse =0;int nse =0;
        int maxArea =0;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]> arr[i])
            {
                element = st.pop();
                pse = st.isEmpty()?-1:st.peek();
                nse =i;
                maxArea = Math.max(maxArea, (nse-pse -1)*arr[element]);
                
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            element = st.pop();
            nse = n;
            pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, (nse-pse-1)*arr[element]);
        }
        return maxArea;
    }
}