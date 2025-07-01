class Solution {
    public int maxChunksToSorted(int[] arr) {

        int temp[] = new int[arr.length];
        for(int i =0;i< arr.length;i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int chunkCount =0;
        long sumOriginal = 0;
        long sumSorted = 0;
        for(int i =0;i<arr.length;i++){
            sumOriginal += arr[i];
            sumSorted += temp[i];

            if(sumOriginal == sumSorted){
                chunkCount ++;
            }

        }
        return chunkCount;
        
    }
}