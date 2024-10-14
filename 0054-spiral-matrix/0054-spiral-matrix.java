class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n= matrix[0].length;
        int rowSt=0, colSt=0, rowEnd= m-1, colEnd= n-1;
        while(list.size()<m*n)
        {
            for(int i =colSt; i<= colEnd;i++)
            {
                list.add(matrix[rowSt][i]);
            }
            for(int i= rowSt +1; i<= rowEnd; i++)
            {
                list.add(matrix[i][colEnd]);

            }
            if(rowSt != rowEnd)
            {
                for(int i = colEnd - 1; i >= colSt; i--)
                {
                    list.add(matrix[rowEnd][i]);
                }
            }
             if(colSt != colEnd)
            {
                for(int i = rowEnd - 1; i >= rowSt + 1; i--)
                {
                    list.add(matrix[i][colSt]);
                }

            }
            colSt++;
            colEnd--;
            rowSt++;
            rowEnd--;

     
        
        }
        return list;
    }
}