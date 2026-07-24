class Solution {
    public int maxArea(int[] nums) {
        int left =0 ;
        int right = nums.length-1;
        int max =Integer.MIN_VALUE;
        while(left<right){
            int l = Math.min(nums[right],nums[left]);
            int b = right-left;
            max=Math.max(max,l*b);

            if(nums[right]<nums[left]) right--;
            else left++;
        }
        return max;
    }
}