class Solution 
{
    public int[] arrayRankTransform(int[] arr) 
    {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank =1;
        for(int i=0;i<sortedArr.length;i++)
        {
            if(!map.containsKey(sortedArr[i]))
            map.put(sortedArr[i], rank++);
        }
        for(int i=0;i<arr.length;i++)
        {
            int x = map.get(arr[i]);
            arr[i]=x;
        }
        return arr;
        
    }
}