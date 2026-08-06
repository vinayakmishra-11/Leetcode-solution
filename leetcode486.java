class Solution {
    public static int solve(int i , int j , int[] nums){
        if(i==j) return nums[j];
        if(i>j) return 0;
        int take_i = nums[i] + Math.min(solve(i+1,j-1,nums),solve(i+2,j,nums));
        int take_j = nums[j] + Math.min(solve(i+1,j-1,nums),solve(i,j-2,nums));
        return Math.max(take_i,take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        if(nums.length==1) return true;
        int p1 =solve(0,nums.length-1,nums);

        int sum=0;
        for(int ele :nums) sum+=ele;

        int p2 = sum-p1;

        if(p1>=p2) return true;
        return false;
    }
}