class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ple = new int[n];
        int[] nle = new int[n];

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            sum = (sum + ((arr[i] * left % mod) * right % mod)) % mod;
        }

        return (int) sum;
    }
}
