class Solution {
    public char kthCharacter(long k, int[] operations) {
        return helper(k, operations, operations.length - 1);
    }

    private char helper(long k, int[] operations, int index) {
        if (index == -1) return 'a'; 

        long len = 1;
        for (int i = 0; i < index; i++) {
            if (operations[i] == 0 || operations[i] == 1) {
                len *= 2;
                if (len >= k) break; 
            }
        }

        long half = len;

        if (operations[index] == 0) {
            if (k <= half) {
                return helper(k, operations, index - 1);
            } else {
                return helper(k - half, operations, index - 1);
            }
        } else { 
            if (k <= half) {
                return helper(k, operations, index - 1);
            } else {
                char prev = helper(k - half, operations, index - 1);
                return prev == 'z' ? 'a' : (char)(prev + 1);
            }
        }
    }
}
