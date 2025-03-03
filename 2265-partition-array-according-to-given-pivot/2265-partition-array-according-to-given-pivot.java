class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            less.add(nums[i]);
            else if(nums[i]>pivot)
            more.add(nums[i]);
            else
            c++;

        }
        int x=0;
        for(int i=0;i<less.size();i++)
        {
            nums[x]= less.get(i);
            x++;
        }
        for(int i=0;i<c;i++)
        {
            nums[x]= pivot;
            x++;
        }
        for(int i=0;i<more.size();i++)
        {
            nums[x]= more.get(i);
            x++;
        }
        return nums;
        
    }
}