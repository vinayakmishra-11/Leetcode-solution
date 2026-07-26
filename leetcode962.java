class Pair{
    int index;
    int number;
    Pair(int i , int n){
        this.index=i;
        this.number=n;
    }
}
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for(int i =0;i<nums.length;i++){
            if(stack.isEmpty()) stack.push(new Pair(i,nums[i]));
            else{
                if(nums[i]<=stack.peek().number){
                    stack.push(new Pair(i,nums[i]));
                }
            }
        }
        int j = nums.length-1;
        int max =0;
        while(!stack.isEmpty() && j>=0){
            if(stack.peek().number<=nums[j]){
                max=Math.max(max,j-stack.peek().index);
                stack.pop();
            }
            else j--;
        }
        return max;
    }
}