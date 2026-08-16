
class Solution {
    public int level(TreeNode root ,boolean[] arr){
        if(root==null) return 0;
        int left=level(root.left,arr);
        int right = level(root.right,arr);
        int diff =Math.abs(left-right);
        if(diff>1) arr[0] =false;
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] arr = new boolean[1];
        arr[0] =true;
   level(root,arr);
    return arr[0];
    }
}