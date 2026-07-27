class Solution {
    public int maxProduct(int[] nums) {
        int i =0 ;
        int j = nums.length-1;
        int max =Integer.MIN_VALUE;
        while(i<j){
            int x = nums[i] -1;
            int y = nums[j] -1;
            max=Math.max(max,x*y);
            if(x<y) i++;
            else j--;
        }
        return max;
    }
}