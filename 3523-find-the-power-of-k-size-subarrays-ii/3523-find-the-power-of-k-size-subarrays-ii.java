class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] num = new int[nums.length];
        int[] vec = new int[nums.length - k + 1];
        num[0] = 1;
        int a = 1;
        // Create the prefix array num for all consecutive numbers
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                a++;
                num[i] = a;
            } else {
                a = 1;
                num[i] = a;
            }
        }
        // Find in the prefix vector if the difference is equal to k hence proving the sub array has consecutive number
        for (int i = 0; i <= nums.length - k; i++) {
            if ((num[i + k - 1] - num[i] + 1) == k) {
                vec[i] = nums[i + k - 1];
            } else {
                vec[i] = -1;
            }
        }
        return vec;
    }
}