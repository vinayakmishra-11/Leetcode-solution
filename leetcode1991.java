class Solution {
    public int findMiddleIndex(int[] nums) {
        int  n =nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(i==0) ans[i] = nums[i];
           else  ans[i] = ans[i-1] +nums[i];
        }
        for(int i =0 ;i<n;i++){
            int ls =0;
            int rs = 0 ;
            if(i==0) {
                ls =0 ;
                rs =ans[n-1] -ans[i];
                if(ls==rs) return i;
            }
            else{
                ls =ans[i-1];
                rs = ans[n-1]-ans[i];
                if(ls==rs) return i;
            }
        }
        return -1;
    }
}