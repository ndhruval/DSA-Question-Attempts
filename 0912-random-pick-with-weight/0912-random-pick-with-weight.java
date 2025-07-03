class Solution {
    int prefixSum[];
    Random random = new Random(); 

    public Solution(int[] w) {
        prefixSum = new int[w.length +1];
        prefixSum[0] =0;

        for(int i=0;i<w.length;i++){
            prefixSum[i+1] = prefixSum[i] + w[i];
        }
        
    }
    
    public int pickIndex() {
        int x = 1+ random.nextInt(prefixSum[prefixSum.length -1]);
        int left = 1, right = prefixSum.length -1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(prefixSum[mid] >= x){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left -1;

        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */