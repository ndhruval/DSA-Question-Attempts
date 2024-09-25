class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                int idx = stack.pop();
                res[idx] = nums[i % len];
            }
            if (i < len) {
                stack.push(i % len);
            }
        }
        return res;
    }
}