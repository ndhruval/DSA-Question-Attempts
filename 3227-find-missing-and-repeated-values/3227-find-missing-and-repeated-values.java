class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for(int i =0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                if(set.contains(grid[i][j]))
                res[0]= grid[i][j];

                set.add(grid[i][j]);
                
            }
        }
        for(int i=1;i<=(grid.length*grid.length);i++)
        {
            if(set.contains(i))
            {
                continue;

            }
            else
            {
                res[1]=i;
                break;

            }
        }
        return res;
        
    }
}