class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }

            // j should never be behind i
            if (j < i) {
                j = i;
            }
        }

        return max;
    }
}
// leet code 1855