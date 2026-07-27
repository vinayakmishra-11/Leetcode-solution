class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[nums.length - 1] - nums[i] == 0) {
                    return 0;
                }
            } else if (i == nums.length - 1) {
                if (nums[i - 1] == 0)
                    return i;
            } else {
                int left = i - 1;
                int right = i + 1;
                if (nums[left] == nums[nums.length - 1] - nums[i]) {
                    return i;
                }
            }
        }
        return ans;
    }
}