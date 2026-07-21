class Solution {
    public boolean findSubarrays(int[] nums) {
        if(nums.length<=2) return false;
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        HashSet<Integer> set = new HashSet<>();
        for(int i =1;i<nums.length;i++){
            ans[i] = nums[i]+nums[i-1];
            if(set.contains(ans[i])) return true;
            else set.add(ans[i]);
        }
        return false;

        // for(int i =0 ;i<ans.length;i++){
        //     if(set.contains(ans[i])) return true;
        //     else set.add(ans[i]);
        // }

        // return false;
    }
}