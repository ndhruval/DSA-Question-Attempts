class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        
        int[] ple = new int[n];
        int[] nle = new int[n];
        int[] pge = new int[n];
        int[] nge = new int[n];

        // PLE (Previous Less Element) - strictly greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // NLE (Next Less Element) - greater or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long minSum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            minSum += nums[i] * left * right;
        }

        st.clear();

        // PGE (Previous Greater Element) - strictly less
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // NGE (Next Greater Element) - less or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            maxSum += nums[i] * left * right;
        }

        return maxSum - minSum;
    }
}
