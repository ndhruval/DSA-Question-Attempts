class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< nums2.length ;i++)
        {
            map.put(nums2[i], i);
        }
        for(int i =0;i< nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
            {
                int t = map.get(nums1[i]);
                for(int j = t+1 ; j< nums2.length;j++)
                {
                    if(nums1[i] < nums2[j])
                    {
                        res[i] = nums2[j];
                        break;
                    }
                    
                }
            }
        }
        return res;

    }
}