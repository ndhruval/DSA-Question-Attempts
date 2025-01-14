class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int n= A.length;
        int c[] = new int[n];
        int count =0;
        for(int i =0;i<n;i++)
        {
            set1.add(A[i]);
            set2.add(B[i]);

            if(A[i] == B[i])
            count++;
            else
            {
                if(set1.contains(B[i]))
                count++;
                if(set2.contains(A[i]))
                count++;
            }
            c[i] = count;
        }
        return c;

        
    }
}