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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        if(head.next==null) return null;
        int count =0 ;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        n=count-n;
        //if(n==1) return head;
        if(n==0) return head.next;
        temp= head;
        for(int i =0 ;i<n-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

    }
}