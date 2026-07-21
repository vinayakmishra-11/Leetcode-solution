class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        int minIdx=0;
        int maxIdx=0;
        for(int i =0;i<nums.length;i++){
            
            if(nums[i]<min){
                min=nums[i];
                minIdx=i;
            }
        }

        for(int i =0;i<nums.length;i++){
           
             if(nums[i]>max){
                max=nums[i];
                maxIdx=i;
            }
        }
         int ans = Integer.MIN_VALUE;

         for(int i =0 ;i<nums.length;i++){
            if(i==minIdx || i==maxIdx) continue;
            ans = Math.max(ans,max+nums[i]-min);
         }
        return ans;
    }
}