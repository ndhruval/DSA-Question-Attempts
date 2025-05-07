class Solution {
    public void gameOfLife(int[][] board) {

        int[][] neigh = new int[board.length][board[0].length];
        for(int i =0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int count =0;
                if(i<board.length-1)
                {
                if(board[i+1][j]==1)
                count++;
                }
                if(i<board.length-1 && j<board[0].length -1)
                {
                if(board[i+1][j+1]==1)
                count++;
                }
                if(i<board.length-1 && j>0)
                {
                if(board[i+1][j-1]==1)
                count++;
                }
                if(j<board[0].length -1)
                {
                if(board[i][j+1]==1)
                count++;
                }
                if(j>0)
                {
                if(board[i][j-1]==1)
                count++;
                }
                if(i>0)
                {
                if(board[i-1][j]==1)
                count++;
                }
                if(i>0 && j>0)
                {
                if(board[i-1][j-1]==1)
                count++;
                }
                if(i>0 && j<board[0].length -1)
                {
                if(board[i-1][j+1]==1)
                count++;
                }

                neigh[i][j] = count;
            }  
        }
        for(int i =0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==1 && neigh[i][j]<2)
                board[i][j]=0;
                else if(board[i][j]==1 && (neigh[i][j]==2 || neigh[i][j]==3))
                board[i][j]=1;
                else if(board[i][j]==1 && neigh[i][j]>3)
                board[i][j]=0;
                else if(board[i][j]==0 && neigh[i][j]==3)
                board[i][j]=1;
            }

        }
        
    }
}