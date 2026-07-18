class Solution {
    public static int gcd(int a, int b) {
    if (b == 0)
        return a;

    return gcd(b, a % b);
}
    public int findGCD(int[] nums) {
      int min  =Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for(int i=0;i<nums.length;i++){
        min=Math.min(nums[i],min);
        max=Math.max(nums[i],max);
      }

      return gcd(min,max);
    }
}