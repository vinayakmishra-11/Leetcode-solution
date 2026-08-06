class Solution {
    public static int solve(int i , int j , int[] nums,int[][] dp){
        if(i==j) return nums[j];
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take_i = nums[i] + Math.min(solve(i+1,j-1,nums,dp),solve(i+2,j,nums,dp));
        int take_j = nums[j] + Math.min(solve(i+1,j-1,nums,dp),solve(i,j-2,nums,dp));
        return dp[i][j]=Math.max(take_i,take_j);
    }
    public boolean stoneGame(int[] nums) {
          int[][] dp = new int[nums.length][nums.length];
        
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        if(nums.length==1) return true;
        int p1 =solve(0,nums.length-1,nums,dp);

        int sum=0;
        for(int ele :nums) sum+=ele;

        int p2 = sum-p1;

        if(p1>=p2) return true;
        return false;
    }
}