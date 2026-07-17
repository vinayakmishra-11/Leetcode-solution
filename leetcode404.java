/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{
    TreeNode root;
    boolean left;
    boolean right;
    Pair(TreeNode root, boolean left, boolean right){
        this.root=root;
        this.left=left;
        this.right=right;
    }
 }
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,false,false));
        int ans = 0;

        while(!q.isEmpty()){
            Pair pp = q.poll();
            TreeNode Root = pp.root;
            boolean left = pp.left;
            boolean right = pp.right;
            
             if(Root.left!=null) q.add(new Pair(Root.left,true,false));
             if(Root.right!=null) q. add(new Pair(Root.right,false,true));
             if(Root.left==null && Root.right==null && left ) ans+=Root.val;

           
        }
        return ans;
    }
}

class Solution {
    

    public int sumOfLeftLeaves(TreeNode root) {
      return   DFS(root, false);
         
    }

    int DFS(TreeNode root, boolean left) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            if (left) {
                return root.val;
            }
            return 0;
        } 
        return DFS(root.left, true) + DFS(root.right, false);
    }
}