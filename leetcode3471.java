class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];

        for (int i = 0; i <= nums.length - k; i++) {
            boolean[] seen = new boolean[51];
            for (int j = i; j < i + k; j++) {
                seen[nums[j]] = true;
            }
            for (int x = 0; x <= 50; x++) {
                if (seen[x]) {
                    freq[x]++;
                }
            }
        }

        int ans = -1;

        for (int x = 0; x <= 50; x++) {
            if (freq[x] == 1) {
                ans = x;
            }
        }

        return ans;
    }
}
