class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int MOD =1000000007;
        int even =1;
        int odd=0, result =0;
        int prefix =0;

        for(int i:arr)
        {
            prefix += i;
            if(prefix %2 ==0)
            {
            result = (result + odd)%MOD;
            even++;
            }
            else
            {
                result = (result+even)%MOD;
                odd++;
            }

        }
        return result;
    }
}