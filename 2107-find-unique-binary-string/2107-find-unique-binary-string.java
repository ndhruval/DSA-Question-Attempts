class Solution {
    public String findDifferentBinaryString(String[] nums) 
    {
        int n= nums[0].length();
        int m = nums.length;

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            set.add(nums[i]);
        }
        ArrayList<String> res = new ArrayList<>();
        generate(set,"",n,res);

        return res.get(0);


        
    }
    public static void generate(HashSet<String> set, String current,int n,ArrayList<String> bin)
    {
        if(current.length()==n)
        {
            if(!set.contains(current))
            bin.add(current);
            return;
        }
        for(char i ='0';i<='1';i++)
        {
            generate(set,current+i,n,bin);
        }
    }
}