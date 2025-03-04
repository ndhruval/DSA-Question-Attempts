class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int[] res = new int[queries.length];
        int[] xor = new int[arr.length+1];
        xor[0]=0;
        for(int i=1;i<=arr.length;i++)
        {
            xor[i] = arr[i-1]^xor[i-1];
        }

        for(int i=0;i<queries.length;i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i]= xor[end+1]^ xor[start];
        }
        return res;
    }
}