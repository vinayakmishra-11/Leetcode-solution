class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<Integer> ll = new ArrayList<>();
        for(int i =0 ;i<nums.length;i++){
            if(nums[i]<=0) continue;
            else {
                ll.add(nums[i]);
            }
        }
        int max = nums[nums.length-1];
        for(int i=0;i<ll.size();i++){
           set.add(ll.get(i));
        }
        if(set.contains(1)==false) return 1 ;
         else {
            for(int i = 1 ;i<max;i++){
              if(set.contains(i)) continue;
              else return i;
            }
         }
         return max+1;
    }
}