class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0, j = 0, k = 0;
		int[] mas = Arrays.copyOf(nums1, m + n);
		while (i < m && j < n) {
			if (mas[i] < nums2[j]) {
				nums1[k++] = mas[i++];
			} else {
				nums1[k++] = nums2[j++];
			}
		}
		while (i < m ) {
			nums1[k++] = mas[i++];
		}
		while (j < n) {
			nums1[k++] = nums2[j++];
		}
	}
}