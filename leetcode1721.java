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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow2 = head;
        for(int i =1;i<k;i++){
            fast=fast.next;
            slow2=slow2.next;
        }

        ListNode slow1 = head;

        while(fast.next!=null){
            fast =fast.next;
            slow1=slow1.next;
        }

        int temp = slow2.val;
        slow2.val = slow1.val;
        slow1.val=temp;

        return head;
        
        
    }
}