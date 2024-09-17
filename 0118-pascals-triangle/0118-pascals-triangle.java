class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<= numRows;i++)
        {
            List<Integer> temp = new ArrayList<Integer>();
            int ans =1;
            temp.add(1);
            for(int j =1;j<i;j++)
            {
                ans = ans*(i-j)/j;
                temp.add(ans);
            }
            result.add(temp);

        }
        return result;


        
    }
}