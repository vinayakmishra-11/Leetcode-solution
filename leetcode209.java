class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0 ; 
        int sum =0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0 ;right<nums.length;right++){
            sum+=nums[right];

            while(sum>=target){
                minLen = Math.min(minLen,right-left+1);
                sum-=nums[left];
                left++;
            }

        }
        if(minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
    
}



class Solution {
    public boolean window(int m,int t , int[] arr){
        int l =0;
        int sum =0 ;
        for(int i=0 ;i<arr.length;i++){
            sum=sum+arr[i];
             if(sum>=t) return true;
            if(i-l+1>=m) {
                sum=sum-arr[l];
                l++;
            }
           
        }
        return false;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length-1;
        int l=1;
        int h =n+1;
        int ans =0 ;

        while(l<=h){
            int m = (l+h)/2;
            boolean flag = window(m,target,nums);
            if(flag) {
                h =m-1;
                ans = m;
            }
            else l=m+1;
        }
        return ans;
    }
}