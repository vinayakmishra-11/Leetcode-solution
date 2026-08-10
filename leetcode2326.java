/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
         int[][] arr = new int[m][n];
        int minr = 0;
        int maxr = arr.length - 1;
        int minc = 0;
        int maxc = arr[0].length - 1;
        ListNode temp =head;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=-1;
            }
        }
        if(head==null) return arr;
        while (minr <= maxr && minc <= maxc && temp!=null) {
            for (int i = minc; i <= maxc && temp!=null; i++) {
               arr[minr][i] = temp.val;
               temp=temp.next;
            }
            minr++;
            
            for (int i = minr; i <= maxr  && temp!=null; i++) {
              arr[i][maxc] = temp.val;
              temp=temp.next;
            }
            maxc--;
            
            if (minr <= maxr  && temp!=null) {
                for (int i = maxc; i >= minc; i--) {
                   if(temp!=null){
                     arr[maxr][i] = temp.val;
                    temp=temp.next;
                   }
                }
                maxr--;
            }
            
            if (minc <= maxc  && temp!=null) {
                for (int i = maxr; i >= minr; i--) {
                    if(temp!=null){
                        arr[i][minc] = temp.val;
                    temp=temp.next;
                    }
                }
                minc++;
            }
        }
        
        return arr;
    }
}