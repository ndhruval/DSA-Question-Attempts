class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) 
        {
            res.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) 
        {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval); // Add the merged interval

        // Add all intervals after the newInterval
        while (i < n) 
        {
            res.add(intervals[i]);
            i++;
        }

        // Convert the result list back to a 2D array
        return res.toArray(new int[res.size()][]);
    }
}