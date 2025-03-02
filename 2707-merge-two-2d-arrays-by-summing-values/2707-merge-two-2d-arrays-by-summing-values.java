class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            set.add(nums1[i][0]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            set.add(nums2[i][0]);
        }
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            map1.put(nums1[i][0],nums1[i][1]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            map2.put(nums2[i][0],nums2[i][1]);
        }


        int res[][] = new int[set.size()][2];
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        int k =0;

        for(int i: arr)
        {
            res[k][0] = i;
            res[k][1] = map1.getOrDefault(i,0) + map2.getOrDefault(i,0);
            k++;
        }
        return res;


        
    }
}

