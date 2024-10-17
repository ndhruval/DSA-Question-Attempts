class Solution 
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.diff == b.diff){
                return b.index - a.index;
            }
            return b.diff - a.diff;
        });
        for(int i=0;i<k;i++)
        {
            int dist = Math.abs(arr[i] - x);
            pq.offer(new Pair(dist, i));
        }
        for(int i=k;i<arr.length;i++)
        {
            int diff = Math.abs(arr[i]-x);
            if(pq.peek().diff> diff)
            {
                
                pq.poll();
                
                pq.offer(new Pair(diff, i));
            }

        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<k;i++)
        {
            int j = pq.poll().index;
            list.add(arr[j]);
        }
        Collections.sort(list);
        return list;
        
        
    }
}
class Pair
{
    int diff;
    int index;

    Pair(int x, int y)
    {
        this.diff=x;
        this.index=y;
    }
}