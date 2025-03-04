class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            int ans = 1;
            temp.add(1);
            for (int j = 1; j <= i; j++) {
                ans = ans * (i - j + 1) / j;  // Using combinatorial formula
                temp.add(ans);
            }
            res.add(temp);
        }
        
        return res;
    }
}