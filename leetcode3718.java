class Solution {
    public int missingMultiple(int[] nums, int k) {
     HashSet<Integer> set = new HashSet<>();

     for(int i =0 ;i<nums.length;i++){
        set.add(nums[i]);
     } 
     for(int i =1 ;i<=102;i++){
        int x = k*i;
        if(set.contains(x)) continue;
        return x;
     }
     return 0;  

    }
}

