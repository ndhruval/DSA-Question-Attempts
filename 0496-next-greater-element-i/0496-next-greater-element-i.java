class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums2.length]; // Next Greater Element array

        // Step 1: Compute NGE for each element in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Pop all smaller or equal elements from stack
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // If stack is empty, no greater element to the right
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            // Push current element to stack
            st.push(nums2[i]);
        }

        // Step 2: Find result for elements in nums1 by looking up in nums2
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = nge[j]; // Use precomputed NGE
                    break;
                }
            }
        }

        return res;
    }
}

